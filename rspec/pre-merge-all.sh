#!/bin/bash -e
BUILD_NAME=${GITHUB_RUN_ID:=local-$(date +%s)}

set -x
set -e
# Verify that Launchable setup is all correct. Useful primarily while you work on integration
launchable verify

# Tell Launchable about the build you are producing and testing
launchable record build --name "$BUILD_NAME" --source ..

# Find 50% of the relevant tests to run for this change
launchable subset --target 50% --build "$BUILD_NAME" --rest remainder.txt rspec spec > subset.txt

# Run rspec with the subset of tests
bundle exec rspec $(cat subset.txt) --format d --format RspecJunitFormatter --out reports/rspec.xml

# Run rspec with the remainder of tests
bundle exec rspec $(cat remainder.txt) --format d --format RspecJunitFormatter --out reports/rspec-remainder.xml
