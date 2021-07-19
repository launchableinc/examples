#!/bin/bash -e
BUILD_NAME=${GITHUB_RUN_ID:=local-$(date +%s)}

echo -e "\n=== BEGIN LAUNCHABLE ==="
echo -e "\n# Install the Launchable CLI. If you can, install it as part of the builder image to speed things up"
echo -e "# Command: pip3 install --user launchable~=1.0 > /dev/null\n"

(set -x; pip3 install --user launchable~=1.0 > /dev/null)

export PATH=~/.local/bin:$PATH

echo -e "\n# Verify that Launchable setup is all correct. Useful primarily while you work on integration"
echo -e "# Command: launchable verify\n"

(set -x; launchable verify)

echo -e "\n# Tell Launchable about the build you are producing and testing"
echo -e "# Command: launchable record build --name \"\$BUILD_NAME\" --source ..\n"

(set -x; launchable record build --name "$BUILD_NAME" --source ..)

echo -e "\n# Find 25% of the relevant tests to run for this change"
echo -e "# Command: launchable subset --target 25% --build \"\$BUILD_NAME\" gradle src/test/java > subset.txt\n"

(set -x; launchable subset --target 25% --build "$BUILD_NAME" gradle src/test/java > subset.txt)

echo -e "\n# Inspect the subset file"
echo -e "# Command: cat subset.txt\n"

(set -x; cat subset.txt)

function record() {
  echo -e "\n# Record test results"
  echo -e "# Command: launchable record tests --build \"\$BUILD_NAME\" gradle build/test-results/test\n"
  
  (set -x; launchable record tests --build "$BUILD_NAME" gradle build/test-results/test)
  
  echo -e "\n=== END LAUNCHABLE ===\n"
}

trap record EXIT

echo -e "\n# Run gradle with the subset of tests"
echo -e "# Command: ./gradlew test \$(< subset.txt)\n"

(set -x; ./gradlew test $(< subset.txt))
