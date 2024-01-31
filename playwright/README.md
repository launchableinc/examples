# rocket-car-playwright

## Recording test results

```sh
$ playwright test --reporter=junit > report.xml

$ BUILD_NAME=test
$ launchable record build --name ${BUILD_NAME} --source ..
| Name   | Path   | HEAD Commit                              |
|--------|--------|------------------------------------------|
| .      | .      | e4303d272680af330f96d5ff997ea116a3553cbb |

$ launchable record tests --build ${BUILD_NAME} playwright report.xml

Launchable recorded tests for build 7720923648 (test session 2575438) to workspace launchableinc/rocket-car-playwright from 1 files:

|   Files found |   Tests found |   Tests passed |   Tests failed |   Total duration (min) |
|---------------|---------------|----------------|----------------|------------------------|
|             1 |            26 |             25 |              1 |                   0.42 |

Visit https://app.launchableinc.com/organizations/launchableinc/workspaces/rocket-car-playwright/test-sessions/2575438 to view uploaded test results (or run `launchable inspect tests --test-session-id 2575438`)
```

## Subsetting your test runs

```sh
$ BUILD_NAME=test
$ CONFIDENCE="90%"

$ find ./tests/*.ts | sed -e 's/.\/tests\///' | launchable subset --confidence ${CONFIDENCE} playwright > launchable-subset.txt

Your model is currently in training
Launchable created subset 751189 for build 7720923648 (test session 2575438) in workspace launchableinc/rocket-car-playwright

|           |   Candidates |   Estimated duration (%) |   Estimated duration (min) |
|-----------|--------------|--------------------------|----------------------------|
| Subset    |            2 |                   100.00 |                       0.00 |
| Remainder |            0 |                     0.00 |                       0.00 |
|           |              |                          |                            |
| Total     |            2 |                   100.00 |                       0.00 |

Run `launchable inspect subset --subset-id 751189` to view full subset details

$ playwright test ./tests/$(cat launchable-subset.txt) --reporter=junit > report.xml
```