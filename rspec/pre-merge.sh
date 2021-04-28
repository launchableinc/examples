#!/bin/bash -e
BUILD_NAME=${GITHUB_RUN_ID:=local-$(date +%s)}

set -x
# Verify that Launchable setup is all correct. Useful primarily while you work on integration
launchable verify

# Tell Launchable about the build you are producing and testing
launchable record build --name "$BUILD_NAME" --source ..

# Find 50% of the relevant tests to run for this change
launchable subset --target 50% --build "$BUILD_NAME" rspec spec > subset.txt

# function record() {
#   # Record test results
#   launchable record test --build "$BUILD_NAME" rspec report/
# }

# trap record EXIT

# Run rspec with the subset of tests
bundle exec rspec $(cat subset.txt) --format d --format RspecJunitFormatter --out reports/rspec.xml
