require 'minitest/autorun'
require "sub"

class TestSub < Minitest::Test
  def setup
    @sub = Sub.new
  end

  def test_calc_one
    assert_equal @sub.calc(3, 1), 2
  end

  def test_calc_two
    assert_equal @sub.calc(3, 2), 1
  end

  def test_calc_three
    assert_equal @sub.calc(3, 3), 0
  end
end
