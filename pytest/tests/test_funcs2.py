import pytest


class TestFuncs2:
    @pytest.mark.dependency(depends=["TestFuncs1::test_func1"])
    def test_func3(self):
        assert True == True

    @pytest.mark.dependency(depends=["TestFuncs1::test_func2"])
    def test_func4(self):
        assert False == False
