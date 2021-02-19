require 'minitest/autorun'
require "add"

class TestAdd < Minitest::Test
  def setup
    @add = Add.new
  end

  def test_calc_one
    assert_equal @add.calc(0, 1), 1
  end

  def test_calc_two
    assert_equal @add.calc(0, 2), 2
  end

  def test_calc_three
    assert_equal @add.calc(0, 3), 3
  end
end
