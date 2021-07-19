#!/bin/bash -e
BUILD_NAME=${GITHUB_RUN_ID:=local-$(date +%s)}

echo -e "\n=== BEGIN LAUNCHABLE ==="
echo -e "\n# Install the Launchable CLI. If you can, install it as part of the builder image to speed things up\n"
echo "pip3 install --user launchable~=1.0 > /dev/null"

pip3 install --user launchable~=1.0 > /dev/null

export PATH=~/.local/bin:$PATH

echo -e "\n# Verify that Launchable setup is all correct. Useful primarily while you work on integration\n"
echo "launchable verify"

launchable verify

echo -e "\n# Tell Launchable about the build you are producing and testing\n"
echo "launchable record build --name \"'$BUILD_NAME'\" --source .."

launchable record build --name "$BUILD_NAME" --source ..

echo -e "\n# Find 25% of the relevant tests to run for this change\n"
echo "launchable subset --target 25% --build \"'$BUILD_NAME'\" gradle src/test/java > subset.txt"

launchable subset --target 25% --build "$BUILD_NAME" gradle src/test/java > subset.txt

echo "cat subset.txt"
cat subset.txt

function record() {
  echo -e "\n# Record test results\n"
  echo "launchable record tests --build "$BUILD_NAME" gradle build/test-results/test"
  
  launchable record tests --build "$BUILD_NAME" gradle build/test-results/test
  
  echo -e "\n=== END LAUNCHABLE ===\n"
}

trap record EXIT

echo -e "\n# Run gradle with the subset of tests\n"
echo "./gradlew test '$(< subset.txt)'"
./gradlew test $(< subset.txt)
