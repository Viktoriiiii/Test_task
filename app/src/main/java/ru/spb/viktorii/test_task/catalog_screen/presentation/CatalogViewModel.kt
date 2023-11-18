package ru.spb.viktorii.test_task.catalog_screen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.spb.viktorii.test_task.model.Product
import ru.spb.viktorii.test_task.catalog_screen.network.ProductService

class CatalogViewModel(private val api: ProductService) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    val requestSuccess = MutableLiveData<Boolean>()

    fun getProducts() {
        api.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { products ->
                    _products.value = products
                    requestSuccess.value = true
                },
                { error ->
                    error.printStackTrace()
                    requestSuccess.value = false
                }
            )
    }
}