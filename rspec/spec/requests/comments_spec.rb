require 'rails_helper'

RSpec.describe "comments", type: :request do
  let(:article) { Article.create(title: "Test Title", body: "Test body") }

  describe 'POST #create' do
    it 'success request' do
      post article_comments_path(article), params: { comment: { name: "Test Name", body: "Test Comment" }}
      expect(response.status).to eq 302
    end

    it 'create new record' do
      expect do
        post article_comments_path(article), params: { comment: { name: "Test Name", body: "Test Comment" }}
      end.to change(Comment, :count).from(0).to(1)
    end

    it 'redirect to parent article page' do
      post article_comments_path(article), params: { comment: { name: "Test Name", body: "Test Comment" }}
      expect(response).to redirect_to article
    end
  end
end
