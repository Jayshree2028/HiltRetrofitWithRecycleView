package com.example.hiltretrofitexample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltretrofitexample.models.Products
import com.example.hiltretrofitexample.retrofit.ProductApi
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productApi: ProductApi
) {
    val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>> = _products
    suspend fun getProducts() {
        val result = productApi.getProducts()
        if (result.isSuccessful && result.body() != null) {
            _products.postValue(result.body())
        }
    }
}