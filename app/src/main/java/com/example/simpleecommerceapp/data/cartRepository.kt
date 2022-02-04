package com.example.simpleecommerceapp.data

import androidx.lifecycle.LiveData

class cartRepository (private val productDAO: productDAO){

    val readAllData : LiveData<List<product>> = productDAO.readAllData()

    suspend fun addProduct(product: product){
        productDAO.addProductToCart(product)
    }

}