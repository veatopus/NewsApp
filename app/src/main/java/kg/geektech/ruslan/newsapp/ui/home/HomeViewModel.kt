package kg.geektech.ruslan.newsapp.ui.home

import androidx.lifecycle.MutableLiveData
import kg.geektech.ruslan.newsapp.core.BaseViewModel
import kg.geektech.ruslan.newsapp.data.models.Article
import kg.geektech.ruslan.newsapp.data.network.Status
import kg.geektech.ruslan.newsapp.data.repositorty.ArticleRepository

class HomeViewModel(private val repository: ArticleRepository) : BaseViewModel() {

    val news = MutableLiveData<MutableList<Article>>()

    init {
        fetchNews()
    }

    private fun fetchNews() {
        repository.fetchArticles().observeForever {
            if (it.status == Status.SUCCESS) news.value = it.data!!
        }
    }
}