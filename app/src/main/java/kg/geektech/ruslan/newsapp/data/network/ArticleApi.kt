package kg.geektech.ruslan.newsapp.data.network

import kg.geektech.ruslan.newsapp.data.models.Article
import kg.geektech.ruslan.newsapp.data.models.ArticleModel
import retrofit2.http.GET

interface ArticleApi {

    @GET("api/v2/articles")
    suspend fun fetchArticles() : MutableList<Article>?

}