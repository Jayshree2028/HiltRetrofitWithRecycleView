package com.example.hiltretrofitexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltretrofitexample.models.Products
import com.example.hiltretrofitexample.repository.ProductRepository
import com.example.hiltretrofitexample.retrofit.ProductApi
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) :ViewModel(){
    val productsLiveData : LiveData<List<Products>>
        get() = productRepository.products

    init {
        viewModelScope.launch {
            productRepository.getProducts()
        }
    }
}