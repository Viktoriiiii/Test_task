package ru.spb.viktorii.test_task.catalog_screen.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.spb.viktorii.test_task.model.Product

interface ProductService {
    @GET("products")
    fun getProducts(
        @Query("cat_id") catId: String = "1000457",
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0,
        @Query("base_id") baseId: Int = 1,
        @Query("sort_type") sortType: Int = 0
    ): Single<List<Product>>
}