package ru.spb.viktorii.test_task.catalog_screen.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.spb.viktorii.test_task.catalog_screen.network.ProductService
import ru.spb.viktorii.test_task.catalog_screen.presentation.CatalogViewModel
import ru.spb.viktorii.test_task.utils.BASE_URL

val catalogModule = module {
    single { provideApiService() }
    viewModel { CatalogViewModel(api = get()) }
}

fun provideApiService(): ProductService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    return retrofit.create(ProductService::class.java)
}