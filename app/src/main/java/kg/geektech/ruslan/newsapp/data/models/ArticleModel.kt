package kg.geektech.ruslan.newsapp.data.models

data class ArticleModel(
    var data: MutableList<Article>? = null
)

data class Article(
    var id: String? = null,
    var title: String? = null,
    var imageUrl: String? = null,
    var summary: String? = null,
    var publishedAt: String? = null,
    var newsSite: String? = null,
    var updatedAt: String? = null
)