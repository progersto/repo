package com.betkey.di

import android.content.Context
import com.betkey.data.MainDataManager
import com.betkey.data.PreferencesManager
import com.betkey.network.ApiInterface
import com.betkey.repository.ModelRepository
import com.betkey.ui.MainViewModel
import com.betkey.utils.API_KEY
import com.betkey.utils.BASE_URSL
import com.google.gson.Gson
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val viewModelModule = module {
    viewModel { MainViewModel(get()) }

}

private val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URSL)
            .client(OkHttpClient.Builder()
                .addInterceptor {
                    it.proceed(
                        it.request()
                            .newBuilder()
                            .url(
                                it.request()
                                    .url()
                                    .newBuilder()
                                    .addQueryParameter("apikey", API_KEY)
                                    .build()
                            )
                            .build()
                    )
                }
                .build())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build().create(ApiInterface::class.java)
    }
}

private val dataModule = module {
    single { get<Context>().applicationContext.getSharedPreferences("Prefers", Context.MODE_PRIVATE) }
    single { PreferencesManager(get()) }
    single { MainDataManager(get(), get(), get()) }
    single { ModelRepository(get()) }


}

val appModules = mutableListOf(viewModelModule, networkModule, dataModule)