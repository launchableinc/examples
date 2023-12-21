# Run Java test

```sh
# Install bazelisk.
$ go install github.com/bazelbuild/bazelisk@latest

$ cd java

# Run test via bazel.
$ bazel test src/test/java/com/ninjinkun:all
INFO: Analyzed 9 targets (50 packages loaded, 1215 targets configured).
INFO: Found 9 test targets...
INFO: Elapsed time: 28.982s, Critical Path: 9.55s
INFO: 51 processes: 28 internal, 13 darwin-sandbox, 10 worker.
INFO: Build completed successfully, 51 total actions
//src/test/java/com/ninjinkun:mylib_test1                                PASSED in 2.9s
//src/test/java/com/ninjinkun:mylib_test2                                PASSED in 3.4s
//src/test/java/com/ninjinkun:mylib_test3                                PASSED in 3.0s
//src/test/java/com/ninjinkun:mylib_test4                                PASSED in 3.4s
//src/test/java/com/ninjinkun:mylib_test5                                PASSED in 2.9s
//src/test/java/com/ninjinkun:mylib_test6                                PASSED in 2.7s
//src/test/java/com/ninjinkun:mylib_test7                                PASSED in 3.6s
//src/test/java/com/ninjinkun:mylib_test8                                PASSED in 3.2s
//src/test/java/com/ninjinkun:mylib_test9                                PASSED in 2.6s

Executed 9 out of 9 tests: 9 tests pass.
INFO: Build completed successfully, 51 total actions

# Record commits and builds from repository.
$ BUILD_NAME=test
$ launchable record build --name ${BUILD_NAME} --source ../..
Launchable recorded build test to workspace launchableinc/mothership with commits from 1 repository:

| Name   | Path   | HEAD Commit                              |
|--------|--------|------------------------------------------|
| ../..  | ../..  | 794ee9ee798684480d17538e3cd069db062a77a0 |

# Record test session.
$ launchable record session --build ${BUILD_NAME} > test_session.txt

$ cat test_session.txt
builds/test/test_sessions/5

# Run tests via bazelisk.
$ bazelisk query 'tests(//...)'
Starting local Bazel server and connecting to it...
//src/test/java/com/ninjinkun:mylib_test1
//src/test/java/com/ninjinkun:mylib_test2
//src/test/java/com/ninjinkun:mylib_test3
//src/test/java/com/ninjinkun:mylib_test4
//src/test/java/com/ninjinkun:mylib_test5
//src/test/java/com/ninjinkun:mylib_test6
//src/test/java/com/ninjinkun:mylib_test7
//src/test/java/com/ninjinkun:mylib_test8
//src/test/java/com/ninjinkun:mylib_test9
Loading: 2 packages loaded

# Create test subset for 30% for total duration, and the rest.
$ bazelisk query 'tests(//...)' | launchable subset --target 30% --session "$(cat test_session.txt)" --rest rest.txt bazel > subset.txt
Loading: 0 packages loaded
Loading: 0 packages loaded
Loading: 0 packages loaded
Your model is currently in training
Launchable created subset 6 for build test (test session 5) in workspace launchableinc/mothership

|           |   Candidates |   Estimated duration (%) |   Estimated duration (min) |
|-----------|--------------|--------------------------|----------------------------|
| Subset    |            2 |                  22.2222 |                3.33333e-05 |
| Remainder |            7 |                  77.7778 |                0.000116667 |
|           |              |                          |                            |
| Total     |            9 |                 100      |                0.00012     |

Run `launchable inspect subset --subset-id 6` to view full subset details

# Tests in subset.
$ cat  subset.txt
src/test/java/com/ninjinkun:mylib_test1
src/test/java/com/ninjinkun:mylib_test7

# Test in rest.
$ cat rest.txt
src/test/java/com/ninjinkun:mylib_test4
src/test/java/com/ninjinkun:mylib_test5
src/test/java/com/ninjinkun:mylib_test9
src/test/java/com/ninjinkun:mylib_test3
src/test/java/com/ninjinkun:mylib_test8
src/test/java/com/ninjinkun:mylib_test6
src/test/java/com/ninjinkun:mylib_test2%

# Test subset inspection.
$ launchable inspect subset --subset-id 6
|   Order | Test Path                                              | In Subset   |   Estimated duration (sec) |
|---------|--------------------------------------------------------|-------------|----------------------------|
|       1 | package=src/test/java/com/ninjinkun#target=mylib_test1 | ✔           |                      0.001 |
|       2 | package=src/test/java/com/ninjinkun#target=mylib_test7 | ✔           |                      0.001 |
|       3 | package=src/test/java/com/ninjinkun#target=mylib_test4 |             |                      0.001 |
|       4 | package=src/test/java/com/ninjinkun#target=mylib_test5 |             |                      0.001 |
|       5 | package=src/test/java/com/ninjinkun#target=mylib_test9 |             |                      0.001 |
|       6 | package=src/test/java/com/ninjinkun#target=mylib_test3 |             |                      0.001 |
|       7 | package=src/test/java/com/ninjinkun#target=mylib_test8 |             |                      0.001 |
|       8 | package=src/test/java/com/ninjinkun#target=mylib_test6 |             |                      0.001 |
|       9 | package=src/test/java/com/ninjinkun#target=mylib_test2 |             |                      0.001 |

# Run only tests in subset.
$ bazelisk test $(cat subset.txt)
INFO: Analyzed 2 targets (48 packages loaded, 1200 targets configured).
INFO: Found 2 test targets...
INFO: Elapsed time: 11.154s, Critical Path: 6.06s
INFO: 13 processes: 5 internal, 5 darwin-sandbox, 3 worker.
INFO: Build completed successfully, 13 total actions
//src/test/java/com/ninjinkun:mylib_test1                                PASSED in 2.4s
//src/test/java/com/ninjinkun:mylib_test7                                PASSED in 2.4s

Executed 2 out of 2 tests: 2 tests pass.
INFO: Build completed successfully, 13 total actions

# Run only tests in rest.
$ bazelisk test $(cat rest.txt)
INFO: Analyzed 7 targets (0 packages loaded, 14 targets configured).
INFO: Found 7 test targets...
INFO: Elapsed time: 3.087s, Critical Path: 2.92s
INFO: 29 processes: 15 internal, 7 darwin-sandbox, 7 worker.
INFO: Build completed successfully, 29 total actions
//src/test/java/com/ninjinkun:mylib_test2                                PASSED in 2.5s
//src/test/java/com/ninjinkun:mylib_test3                                PASSED in 2.6s
//src/test/java/com/ninjinkun:mylib_test4                                PASSED in 2.6s
//src/test/java/com/ninjinkun:mylib_test5                                PASSED in 2.6s
//src/test/java/com/ninjinkun:mylib_test6                                PASSED in 2.5s
//src/test/java/com/ninjinkun:mylib_test8                                PASSED in 2.5s
//src/test/java/com/ninjinkun:mylib_test9                                PASSED in 2.5s

Executed 7 out of 7 tests: 7 tests pass.
INFO: Build completed successfully, 29 total actions

# Record test results.
$ launchable record test --session "$(cat test_session.txt)" bazel .
Launchable recorded tests for build test (test session 5) to workspace launchableinc/mothership from 9 files:

|   Files found |   Tests found |   Tests passed |   Tests failed |   Total duration (min) |
|---------------|---------------|----------------|----------------|------------------------|
|             9 |             9 |              9 |              0 |                 0.3022 |

Visit https://app.launchableinc.com/organizations/launchableinc/workspaces/mothership/test-sessions/5 to view uploaded test results (or run `launchable inspect tests --test-session-id 5`)

# See test inspection.
$ launchable inspect tests --test-session-id 5
| Test Path                                                                                                    |   Duration (sec) | Status   | Uploaded At                 |
|--------------------------------------------------------------------------------------------------------------|------------------|----------|-----------------------------|
| package=src/test/java/com/ninjinkun#target=mylib_test3#class=com.ninjinkun.MyLibTest3#testcase=testFibonacci |            2.018 | SUCCESS  | 2022-06-06T00:35:41.982191Z |
| package=src/test/java/com/ninjinkun#target=mylib_test4#class=com.ninjinkun.MyLibTest4#testcase=testFibonacci |            2.017 | SUCCESS  | 2022-06-06T00:35:41.982191Z |
| package=src/test/java/com/ninjinkun#target=mylib_test5#class=com.ninjinkun.MyLibTest5#testcase=testFibonacci |            2.018 | SUCCESS  | 2022-06-06T00:35:41.982191Z |
| package=src/test/java/com/ninjinkun#target=mylib_test2#class=com.ninjinkun.MyLibTest2#testcase=testFibonacci |            2.009 | SUCCESS  | 2022-06-06T00:35:41.982191Z |
| package=src/test/java/com/ninjinkun#target=mylib_test7#class=com.ninjinkun.MyLibTest7#testcase=testFibonacci |            2.012 | SUCCESS  | 2022-06-06T00:35:41.982191Z |
| package=src/test/java/com/ninjinkun#target=mylib_test9#class=com.ninjinkun.MyLibTest9#testcase=testFibonacci |            2.02  | SUCCESS  | 2022-06-06T00:35:41.982191Z |
| package=src/test/java/com/ninjinkun#target=mylib_test8#class=com.ninjinkun.MyLibTest8#testcase=testFibonacci |            2.012 | SUCCESS  | 2022-06-06T00:35:41.982191Z |
| package=src/test/java/com/ninjinkun#target=mylib_test1#class=com.ninjinkun.MyLibTest1#testcase=testFibonacci |            2.012 | SUCCESS  | 2022-06-06T00:35:41.982191Z |
| package=src/test/java/com/ninjinkun#target=mylib_test6#class=com.ninjinkun.MyLibTest6#testcase=testFibonacci |            2.012 | SUCCESS  | 2022-06-06T00:35:41.982191Z |
```

# Run C++ tests

```sh
$ cd cpp
$ bazel test test:hello-test
```
