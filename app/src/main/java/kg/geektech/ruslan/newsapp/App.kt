package kg.geektech.ruslan.newsapp

import android.app.Application
import kg.geektech.ruslan.newsapp.di.databaseModule
import kg.geektech.ruslan.newsapp.di.networkModule
import kg.geektech.ruslan.newsapp.di.repositoryModule
import kg.geektech.ruslan.newsapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()

            modules(listOf(viewModelModule, databaseModule, networkModule, repositoryModule))
        }

    }
}
