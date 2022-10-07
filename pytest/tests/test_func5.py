from time import sleep
import pytest


@pytest.mark.parametrize(
    ("test_input", "expected"),
    [
        ("3+5", 8),
        ("2+4", 6),
        ("6*9", 54),
    ],
)
def test_func5(test_input, expected):
    assert eval(test_input) == expected

@pytest.mark.parametrize("x", [0, 1])
@pytest.mark.parametrize("y", [2, 3])
def test_foo(x, y):
    sleep(1)
