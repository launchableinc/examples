Rails.application.routes.draw do
  resources :articles do
    resources :comments, only: :create
  end
end
