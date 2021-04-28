require 'rails_helper'

RSpec.describe Comment, type: :model do
  let(:article) { Article.create(title: "Test Title", body: "Test body") }
  describe "validation" do
    it "is invalid without a name" do
      expect( article.comments.build(name: nil, body: "Test comment")).to_not be_valid
    end

    it "is invalid without a body" do
      expect( article.comments.build(name: "Test Name", body: nil)).to_not be_valid
    end
  end
end
