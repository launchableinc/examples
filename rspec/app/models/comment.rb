class Comment < ApplicationRecord
  validates :name, presence: true
  validates :body, presence: true

  belongs_to :article
end
