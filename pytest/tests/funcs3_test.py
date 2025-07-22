import pytest


@pytest.mark.order(1)
@pytest.mark.dependency(name="a")
def test_func4():
    assert 1 == True

@pytest.mark.order(2)
@pytest.mark.dependency(name="b", depends=["a"])
def test_func5():
    assert 1 == False
