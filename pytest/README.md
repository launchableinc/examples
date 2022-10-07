# Pytest


## Recording test results

```shell
$ BUILD_NAME=test
$ launchable record build --name ${BUILD_NAME} --source ..
Launchable recorded 1 commit from repository /Users/shibuiyuusuke/launchable/samples/examples
Launchable recorded build test to workspace launchableinc/mothership with commits from 1 repository:

| Name   | Path   | HEAD Commit                              |
|--------|--------|------------------------------------------|
| ..     | ..     | 7f74ad2e0e72481a32f645e8b5425d6ece19c3d9 |


$ pytest --junitxml=./report.xml tests/ 
config=<class '_pytest.config.Config'>
============================================================ test session starts =============================================================
platform darwin -- Python 3.10.4, pytest-7.1.2, pluggy-1.0.0
rootdir: /Users/shibuiyuusuke/launchable/samples/examples/pytest
plugins: launchable-0.1.0
collected 15 items

tests/funcs3_test.py .F                                                                                                                [ 13%]
tests/test_func5.py ..F....                                                                                                            [ 60%]
tests/test_funcs1.py .F                                                                                                                [ 73%]
tests/test_funcs2.py ..                                                                                                                [ 86%]
tests/test_mod.py .                                                                                                                    [ 93%]
tests/fooo/test_func4.py .                                                                                                             [100%]

================================================================== FAILURES ==================================================================
_________________________________________________________________ test_func5 _________________________________________________________________

    def test_func5():
>       assert 1 == False
E       assert 1 == False

tests/funcs3_test.py:5: AssertionError
_____________________________________________________________ test_func5[6*9-42] _____________________________________________________________

test_input = '6*9', expected = 42

    @pytest.mark.parametrize(
        ("test_input", "expected"),
        [
            ("3+5", 8),
            ("2+4", 6),
            ("6*9", 42),
        ],
    )
    def test_func5(test_input, expected):
>       assert eval(test_input) == expected
E       AssertionError: assert 54 == 42
E        +  where 54 = eval('6*9')

tests/test_func5.py:14: AssertionError
_________________________________________________________________ test_func2 _________________________________________________________________

    def test_func2():
>       assert 1 == False
E       assert 1 == False

tests/test_funcs1.py:5: AssertionError
--------------------------- generated xml file: /Users/shibuiyuusuke/launchable/samples/examples/pytest/report.xml ---------------------------
========================================================== short test summary info ===========================================================
FAILED tests/funcs3_test.py::test_func5 - assert 1 == False
FAILED tests/test_func5.py::test_func5[6*9-42] - AssertionError: assert 54 == 42
FAILED tests/test_funcs1.py::test_func2 - assert 1 == False
======================================================== 3 failed, 12 passed in 4.18s ========================================================
[22-10-06 12:20:45] shibuiyuusuke:~/launchable/samples/examples/pytest


$ launchable record tests --build ${BUILD_NAME} pytest .
Launchable recorded tests for build test (test session 28) to workspace launchableinc/mothership from 1 files:

|   Files found |   Tests found |   Tests passed |   Tests failed |   Total duration (min) |
|---------------|---------------|----------------|----------------|------------------------|
|             1 |            15 |             12 |              3 |                  0.067 |

Visit https://app.launchableinc.com/organizations/launchableinc/workspaces/mothership/test-sessions/28 to view uploaded test results (or run `launchable inspect tests --test-session-id 28`)


$ launchable inspect tests --test-session-id 28
| Test Path                                                   |   Duration (sec) | Status   | Uploaded At                 |
|-------------------------------------------------------------|------------------|----------|-----------------------------|
| class=tests.fooo.test_func4#testcase=test_func6             |            0     | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_mod.TestClass#testcase=test__can_print_aaa |            0     | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_funcs2#testcase=test_func4                 |            0     | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_funcs2#testcase=test_func3                 |            0     | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_funcs1#testcase=test_func2                 |            0.001 | FAILURE  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_funcs1#testcase=test_func1                 |            0     | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_func5#testcase=test_foo[3-1]               |            1.003 | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_func5#testcase=test_foo[3-0]               |            1.006 | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_func5#testcase=test_foo[2-1]               |            1.003 | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_func5#testcase=test_foo[2-0]               |            1.005 | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_func5#testcase=test_func5[6*9-42]          |            0.001 | FAILURE  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_func5#testcase=test_func5[2+4-6]           |            0.001 | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.test_func5#testcase=test_func5[3+5-8]           |            0.001 | SUCCESS  | 2022-10-06T05:19:35.327945Z |
| class=tests.funcs3_test#testcase=test_func5                 |            0.001 | FAILURE  | 2022-10-06T05:19:35.327945Z |
| class=tests.funcs3_test#testcase=test_func4                 |            0.001 | SUCCESS  | 2022-10-06T05:19:35.327945Z |

```

---

## Subsetting your test runs

```shell
$ BUILD_NAME=test
$ TARGET="50%"


$ launchable subset --target ${TARGET} --build ${BUILD_NAME} pytest . > subset.txt
Your model is currently in training
Launchable created subset 47 for build ppp (test session 29) in workspace launchableinc/mothership

|           |   Candidates |   Estimated duration (%) |   Estimated duration (min) |
|-----------|--------------|--------------------------|----------------------------|
| Subset    |            8 |                       50 |                0.000133333 |
| Remainder |            8 |                       50 |                0.000133333 |
|           |              |                          |                            |
| Total     |           16 |                      100 |                0.000266667 |

Run `launchable inspect subset --subset-id 47` to view full subset details


$ launchable inspect subset --subset-id 47
|   Order | Test Path                                                                          | In Subset   |   Estimated duration (sec) |
|---------|------------------------------------------------------------------------------------|-------------|----------------------------|
|       1 | file=tests/test_func5.py#class=tests.test_func5#testcase=test_foo[2-0]             | ✔           |                      0.001 |
|       2 | file=tests/test_func5.py#class=tests.test_func5#testcase=test_foo[3-0]             | ✔           |                      0.001 |
|       3 | file=tests/test_func5.py#class=tests.test_func5#testcase=test_foo[3-1]             | ✔           |                      0.001 |
|       4 | file=tests/test_func5.py#class=tests.test_func5#testcase=test_func5[3+5-8]         | ✔           |                      0.001 |
|       5 | file=tests/test_func5.py#class=tests.test_func5#testcase=test_foo[2-1]             | ✔           |                      0.001 |
|       6 | file=tests/test_funcs1.py#class=tests.test_funcs1#testcase=test_func1              | ✔           |                      0.001 |
|       7 | file=tests/funcs3_test.py#class=tests.funcs3_test#testcase=test_func4              | ✔           |                      0.001 |
|       8 | file=tests/test_funcs2.py#class=tests.test_funcs2#testcase=test_func4              | ✔           |                      0.001 |
|       9 | file=tests/fooo/test_func4.py#class=tests.fooo.test_func4#testcase=test_func6      |             |                      0.001 |
|      10 | file=config=<class '_pytest.config.Config'>#class=config=<class '_pytest.config    |             |                      0.001 |
|      11 | file=tests/test_funcs2.py#class=tests.test_funcs2#testcase=test_func3              |             |                      0.001 |
|      12 | file=tests/test_funcs1.py#class=tests.test_funcs1#testcase=test_func2              |             |                      0.001 |
|      13 | file=tests/test_func5.py#class=tests.test_func5#testcase=test_func5[6*9-42]        |             |                      0.001 |
|      14 | file=tests/test_mod.py#class=tests.test_mod.TestClass#testcase=test__can_print_aaa |             |                      0.001 |
|      15 | file=tests/funcs3_test.py#class=tests.funcs3_test#testcase=test_func5              |             |                      0.001 |
|      16 | file=tests/test_func5.py#class=tests.test_func5#testcase=test_func5[2+4-6]         |             |                      0.001 |


$ cat subset.txt
tests/test_func5.py::test_foo[2-0]
tests/test_func5.py::test_foo[3-0]
tests/test_func5.py::test_foo[3-1]
tests/test_func5.py::test_func5[3+5-8]
tests/test_func5.py::test_foo[2-1]
tests/test_funcs1.py::test_func1
tests/funcs3_test.py::test_func4
tests/test_funcs2.py::test_func4


$ pytest $(cat subset.txt)
config=<class '_pytest.config.Config'>
============================================================ test session starts =============================================================
platform darwin -- Python 3.10.4, pytest-7.1.2, pluggy-1.0.0
rootdir: /Users/shibuiyuusuke/launchable/samples/examples/pytest
plugins: launchable-0.1.0
collected 8 items

tests/test_func5.py .....                                                                                                              [ 62%]
tests/test_funcs1.py .                                                                                                                 [ 75%]
tests/funcs3_test.py .                                                                                                                 [ 87%]
tests/test_funcs2.py .                                                                                                                 [100%]

============================================================= 8 passed in 4.03s ==============================================================



$ launchable subset --target ${TARGET} --build ${BUILD_NAME} --split pytest .
subset/48
Your model is currently in training
Launchable created subset 48 for build test (test session 5) in workspace launchableinc/mothership

|           |   Candidates |   Estimated duration (%) |   Estimated duration (min) |
|-----------|--------------|--------------------------|----------------------------|
| Subset    |            8 |                       50 |                0.000133333 |
| Remainder |            8 |                       50 |                0.000133333 |
|           |              |                          |                            |
| Total     |           16 |                      100 |                0.000266667 |

Run `launchable inspect subset --subset-id 48` to view full subset details



$ launchable split-subset --subset-id subset/48 --bin 1/2 pytest
tests/test_func5.py::test_foo[3-0]
tests/test_funcs2.py::test_func4
tests/test_func5.py::test_foo[2-1]
tests/test_mod.py::TestClass::test__can_print_aaa


$ launchable split-subset --subset-id subset/8 --bin 2/2 pytest
tests/test_func5.py::test_func5[6*9-42]
tests/test_func5.py::test_func5[3+5-8]
tests/test_funcs2.py::test_func3
tests/test_func5.py::test_foo[3-1]
```
