package com.example.simpleecommerceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleecommerceapp.common.addToCart
import com.example.simpleecommerceapp.data.cartViewModel
import com.example.simpleecommerceapp.data.product


class ProductsAdaptor (private val _product_list: List<productItem>, mCartViewModel: cartViewModel): RecyclerView.Adapter<ProductsAdaptor.productViewHolder>(){
    private var mCartViewModel: cartViewModel = mCartViewModel
    class productViewHolder (itemview: View): RecyclerView.ViewHolder(itemview){
        val productImage: ImageView = itemview.findViewById(R.id._product_picture)
        val productName: TextView = itemview.findViewById(R.id._product_name)
        val productDescription: TextView = itemview.findViewById(R.id._product_description)
        val productPrice: TextView = itemview.findViewById(R.id._product_price)
        val cartButton: ImageView = itemview.findViewById(R.id._add_to_cart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productViewHolder {
        val itemView = LayoutInflater.from(parent.context ).inflate(R.layout.product_card,parent,false)
        return productViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: productViewHolder, position: Int) {
        val currentProduct = _product_list[position]
        holder.productImage.setImageResource(currentProduct.productResource)
        holder.productName.text = currentProduct._product_name
        holder.productDescription.text = currentProduct._product_description
        holder.productPrice.text = currentProduct._product_price
        holder.cartButton.setImageResource(currentProduct.cartResource)

        holder.cartButton.setOnClickListener{
            mCartViewModel.addProductToCart(
                product(
                    0,
                    holder.productName.text as String,
                    holder.productDescription.text as String,
                    holder.productPrice.text as String
                )
            )
            addToCart(
                productItem(
                    getImageResourse(holder.productName.text as String),
                    R.drawable._add_to_cart_icon,
                    holder.productName.text as String,
                    holder.productDescription.text as String,
                    holder.productPrice.text as String
                )
            )

            Toast.makeText(holder.cartButton.context, "Added to Cart!", Toast.LENGTH_SHORT).show()

        }
    }

    private fun addToCartDB() {
        TODO("Not yet implemented")
    }

    fun getImageResourse(name: String): Int{
        val rnds = (0..2).random()
        if (rnds == 0){
            return R.drawable._product_one
        }
        else if (rnds == 1){
            return R.drawable._product_two
        }
        else{
            return R.drawable.product_three
        }
    }
    override fun getItemCount(): Int {
        return _product_list.size
    }
}