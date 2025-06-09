module FridayStepHelper
  def is_it_friday(day)
    if day == 'Friday'
      'TGIF'
    else
      'Nope'
    end
  end
end
World FridayStepHelper

Given("this year is 2023") do
  @year = '2023'
  puts "output: #{@year}"
end

Given("this month is January") do
  @month = 'January'
  puts "output: #{@month}"
end

Given("today is {string}") do |given_day|
  @today = given_day
end

Given("today is Sunday") do
  @today = 'Sunday'
end

Given("today is Friday") do
  @today = 'Friday'
end

Given("it is sunny today") do
  @weather = 'sunny'
end

Given("the current UTC is 01:00 AM") do
  @time = '01:00'
end

Given("the current EST is 08:00 PM") do
  @time = '20:00'
end

Given("the current JST is 10:00 AM") do
  @time = '10:00'
end

When("I ask whether it's Friday yet") do
  @actual_answer = is_it_friday(@today)
end

Then("I should be told {string}") do |expected_answer|
  expect(@actual_answer).to eq(expected_answer)
end
