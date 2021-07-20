#!/bin/bash -e
BUILD_NAME=${GITHUB_RUN_ID:=local-$(date +%s)}

echo
echo "===== BEGIN LAUNCHABLE ====="

echo
echo "# Install the Launchable CLI. If you can, install it as part of the builder image to speed things up"
echo "# Command: pip3 install --user launchable~=1.0 > /dev/null"
echo
pip3 install --user launchable~=1.0 > /dev/null

export PATH=~/.local/bin:$PATH

echo "# Verify that Launchable setup is all correct. Useful primarily while you work on integration"
echo "# Command: launchable verify"
echo
launchable verify

echo
echo "# Tell Launchable about the build you are producing and testing"
echo "# Command: launchable record build --name \"\$BUILD_NAME\" --source .."
echo
launchable record build --name "$BUILD_NAME" --source ..

echo
echo "# Find 25% of the relevant tests to run for this change"
echo "# Command: launchable subset --target 25% --build \"\$BUILD_NAME\" gradle src/test/java > subset.txt"
launchable subset --target 25% --build "$BUILD_NAME" gradle src/test/java > subset.txt

echo
echo "# Inspect the subset file"
echo "# Command: cat subset.txt"
cat subset.txt

function record() {
  echo
  echo "# Record test results"
  echo "# Command: launchable record tests --build \"\$BUILD_NAME\" gradle build/test-results/test"
  echo
  launchable record tests --build "$BUILD_NAME" gradle build/test-results/test
  
  echo
  echo "===== END LAUNCHABLE ====="
  echo
}

trap record EXIT

echo
echo "# Run gradle with the subset of tests"
echo "# Command: ./gradlew test \$(< subset.txt)"
echo
./gradlew test $(< subset.txt)
