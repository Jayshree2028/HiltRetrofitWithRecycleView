package com.example.hiltretrofitexample.retrofit

import com.example.hiltretrofitexample.models.Products
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("/products")
    suspend fun getProducts(): Response<List<Products>>
}