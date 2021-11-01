For pytest research

# setup
```shell
$ pipenv install
$ pipenv shell
```

# command

```shell
$  pytest --collect-only  -q
tests/funcs3_test.py::test_func4
tests/funcs3_test.py::test_func5
tests/test_funcs1.py::test_func1
tests/test_funcs1.py::test_func2
tests/test_funcs2.py::test_func3
tests/test_funcs2.py::test_func4
tests/test_mod.py::TestClass::test__can_print_aaa
tests/fooo/func4_test.py::test_func6

8 tests collected in 0.03s
```
