package com.example.simpleecommerceapp

object common {
    private var cartItems = ArrayList<productItem>()
    val dummy_text = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit."
    fun addToCart(item: productItem) {
        cartItems.add(item)
    }
    fun getCartItems(): ArrayList<productItem>{
        return cartItems
    }
}