require 'minitest/autorun'
require "div"

class TestDiv < Minitest::Test
  def setup
    @div = Div.new
  end

  def test_calc_one
    assert_equal @div.calc(6, 1), 6
  end

  def test_calc_two
    assert_equal @div.calc(6, 2), 3
  end

  def test_calc_three
    assert_equal @div.calc(6, 3), 2
  end
end
