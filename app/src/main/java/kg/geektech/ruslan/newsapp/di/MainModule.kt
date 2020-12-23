package kg.geektech.ruslan.newsapp.di

import kg.geektech.ruslan.newsapp.data.network.RetrofitClient
import kg.geektech.ruslan.newsapp.data.repositorty.ArticleRepository
import kg.geektech.ruslan.newsapp.ui.home.HomeViewModel
import kg.geektech.ruslan.newsapp.ui.home.view_pager.PageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { PageViewModel() }
}

var databaseModule = module {


}

var networkModule = module {
    factory { RetrofitClient().instanceRetrofit() }
}

var repositoryModule = module {
    factory { ArticleRepository(get()) }
}