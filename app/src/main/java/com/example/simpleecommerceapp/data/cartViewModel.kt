package com.example.simpleecommerceapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class cartViewModel(application: Application): AndroidViewModel(application){
    val readAllData : LiveData<List<product>>
    private val repository : cartRepository

    init {
        val productDao = cartDatabase.getDatabase(application).productDAO()
        repository = cartRepository(productDao)
        readAllData = repository.readAllData
    }

    fun addProductToCart (product: product){
        viewModelScope.launch(Dispatchers.IO){
            repository.addProduct(product)
        }
    }
}