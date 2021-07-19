#!/bin/bash -e
BUILD_NAME=${GITHUB_RUN_ID:=local-$(date +%s)}

echo -e "\n === BEGIN LAUNCHABLE ===\n"

echo -e "\n# Get Launchable CLI installed. If you can, make it a part of the builder image to speed things up\n"
(set -x; pip3 install --user launchable~=1.0 > /dev/null)
export PATH=~/.local/bin:$PATH

echo -e "\n# Verify that Launchable setup is all correct. Useful primarily while you work on integration\n"
(set -x; launchable verify)

echo -e "\n# Tell Launchable about the build you are producing and testing\n"
(set -x; launchable record build --name "$BUILD_NAME" --source ..)

echo -e "\n# Find 25% of the relevant tests to run for this change\n"
(set -x; launchable subset --target 25% --build "$BUILD_NAME" gradle src/test/java > subset.txt)
(set -x; cat subset.txt)

function record() {
  echo -e "\n# Record test results\n"
  (set -x; launchable record test --build "$BUILD_NAME" gradle build/test-results/test)
}

trap record EXIT

(set +B; echo -e "\n# Run gradle with the subset of tests (./gradlew test $(< subset.txt))\n")
(set -x; ./gradlew test $(< subset.txt))

echo -e "\n === END LAUNCHABLE ===\n"
