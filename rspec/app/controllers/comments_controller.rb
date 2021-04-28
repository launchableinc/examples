class CommentsController < ApplicationController
  def create
    article = Article.find(params[:article_id])
    article.comments.create! comment_params
    redirect_to article
  end

  private
  def comment_params
    params.require(:comment).permit(:name, :body)
  end
end
