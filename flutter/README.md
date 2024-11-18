# flutter example

## Recording test results

```sh
$ BUILD_NAME=test
$ launchable record build --name ${BUILD_NAME}
# will print collected commit information
# Please install dependencies before execute test
$ flutter pub get
# Execute test with `--machine` option
$ flutter test --machine > report.json
$ launchable record tests flutter report.json
Launchable recorded tests for build 11884403890 (test session 3441847) to workspace launchableinc/rocket-car-flutter from 1 files:

|   Files found |   Tests found |   Tests passed |   Tests failed |   Total duration (min) |
|---------------|---------------|----------------|----------------|------------------------|
|             1 |             3 |              1 |              1 |                   0.40 |

Visit https://app.launchableinc.com/organizations/launchableinc/workspaces/rocket-car-flutter/test-sessions/3441847 to view uploaded test results (or run `launchable inspect tests --test-session-id 3441847`)
```

___

## Subsettinging your test runs

```sh
$ BUILD_NAME=test
$ CONFIDENCE="50%"
$ launchable subset --build ${BUILD_NAME} --confidence ${CONFIDENCE} \
  flutter test/**/*_test.dart > subset.txt

$ flutter test $(cat subset.txt) --machine > report.json
```



