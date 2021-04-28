require 'rails_helper'

RSpec.describe Article, type: :model do
  describe "validation" do
    it "only the body is required." do
      expect(Article.new(title: nil, body: "test")).to_not be_valid
    end
  end
end
