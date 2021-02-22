require 'minitest/autorun'
require "mul"

class TestMul < Minitest::Test
  def setup
    @mul = Mul.new
  end

  def test_calc_one
    assert_equal @mul.calc(1, 1), 1
  end

  def test_calc_two
    assert_equal @mul.calc(1, 2), 2
  end

  def test_calc_three
    assert_equal @mul.calc(1, 3), 3
  end
end
