#!/bin/bash -ex
BUILD_NAME="${GITHUB_RUN_ID:=local-$(date +%s)}"

pip3 install --user launchable~=1.0
export PATH=~/.local/bin:$PATH

# verify that Launchable is correctly setup
launchable verify

launchable record build --name "$BUILD_NAME" --source ..

launchable subset --build "$BUILD_NAME" --target 25% gradle src/test/java > subset.txt

function record() {
  launchable record tests --build "$BUILD_NAME" gradle build/test-results/test
}

trap record EXIT

./gradlew test $(< subset.txt)

