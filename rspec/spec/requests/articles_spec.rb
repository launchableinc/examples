require 'rails_helper'

RSpec.describe "Articles", type: :request do
  describe "GET /index" do
    before do
      Article.create(title: "Test Title", body: "Test body")
    end

    it "success request" do
      get articles_url
      expect(response.status).to eq 200
    end

    it "show titles" do
      get articles_url
      expect(response.body).to include "Test Title"
    end
  end

  describe "GET /show" do
    let(:article){ Article.create(title: "Test Title", body: "Test body") }

    it "success request" do
      get article_url(article.id)
      expect(response.status).to eq 200
    end

    it "show titles and body" do
      get article_url(article.id)
      expect(response.body).to include "Test Title"
      expect(response.body).to include "Test body"
    end

    context "has comments" do
      before { article.comments.create! name: "Test Name", body: "Test Comments"}
      it "show comments" do
        get article_url(article.id)
        expect(response.body).to include "Test Name"
        expect(response.body).to include "Test Comments"
      end
    end
  end

  describe "GET /new" do

    it "success request" do
      get new_article_url
      expect(response.status).to eq 200
    end
  end

  describe 'POST #create' do
    it 'success request' do
      post articles_url, params: { article: { title: "Test Title", body: "Test Body" }}
      expect(response.status).to eq 302
    end

    it 'create new record' do
      expect do
        post articles_url, params: { article: { title: "Test Title", body: "Test Body" }}
      end.to change(Article, :count).from(0).to(1)
    end

    it 'redirect to created article page' do
      post articles_url, params: { article: { title: "Test Title", body: "Test Body" }}
      expect(response).to redirect_to Article.last
    end
  end
end
