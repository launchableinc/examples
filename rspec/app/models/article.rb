class Article < ApplicationRecord
  validates :title, presence: true
  validates :body, presence: true

  has_many :comments
end
