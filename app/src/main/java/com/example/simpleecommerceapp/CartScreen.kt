package com.example.simpleecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleecommerceapp.common.getCartItems
import com.example.simpleecommerceapp.data.cartViewModel
import com.example.simpleecommerceapp.data.product
import java.util.*

class CartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_screen)
        var mCartViewModel = ViewModelProvider(this).get(cartViewModel::class.java)

        val productList = getCartItems()

        val productView : RecyclerView = findViewById(R.id._products)
        val adaptor = CartAdapter()
        productView.adapter = adaptor
        productView.layoutManager =  LinearLayoutManager(this)
        mCartViewModel.readAllData.observe(this, androidx.lifecycle.Observer { product ->
            adaptor.setData(product)
        })
    }
}