#!/bin/bash -e
BUILD_NAME=${GITHUB_RUN_ID:=local-$(date +%s)}

echo "# Get Launchable CLI installed. If you can, make it a part of the builder image to speed things up"
(set -x; pip3 install --user launchable~=1.0 > /dev/null)
export PATH=~/.local/bin:$PATH

echo "# Verify that Launchable setup is all correct. Useful primarily while you work on integration"
(set -x; launchable verify)

echo "# Tell Launchable about the build you are producing and testing"
(set -x; launchable record build --name "$BUILD_NAME" --source ..)

echo "# Find 25% of the relevant tests to run for this change"
(set -x; launchable subset --target 25% --build "$BUILD_NAME" gradle src/test/java > subset.txt)
(set -x; cat subset.txt)

function record() {
  echo "# Record test results"
  (set -x; launchable record test --build "$BUILD_NAME" gradle build/test-results/test)
}

trap record EXIT

echo "# Run gradle with the subset of tests"
(set -x; ./gradlew test $(< subset.txt))
