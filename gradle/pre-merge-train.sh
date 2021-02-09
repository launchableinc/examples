#!/bin/bash -e
BUILD_NAME=${GITHUB_RUN_ID:=local-$(date +%s)}

# Get Launchable CLI installed. If you can, make it a part of the builder image to speed things up
pip3 install --user launchable~=1.0 > /dev/null
export PATH=~/.local/bin:$PATH

set -x
# Verify that Launchable setup is all correct. Useful primarily while you work on integration
launchable verify

# Record build to send changes over for training
launchable record build --name "$BUILD_NAME" --source ..

function record() {
  # record tests to send test results for training
  launchable record test --build "$BUILD_NAME" gradle build/test-results/test
}

trap record EXIT

# Run gradle with the subset of tests
./gradlew test 
