package kg.geektech.ruslan.newsapp.data.repositorty

import androidx.lifecycle.liveData
import kg.geektech.ruslan.newsapp.data.network.ArticleApi
import kg.geektech.ruslan.newsapp.data.network.Resource
import kotlinx.coroutines.Dispatchers

class ArticleRepository(private val api: ArticleApi) {

    fun fetchArticles() = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        try {
            emit(Resource.success(api.fetchArticles()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }
    }
}