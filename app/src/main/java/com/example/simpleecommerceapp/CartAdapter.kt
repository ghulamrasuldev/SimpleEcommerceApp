package com.example.simpleecommerceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleecommerceapp.data.product

class CartAdapter: RecyclerView.Adapter<CartAdapter.cartViewHolder>(){
    private var productList = emptyList<product>()
    class cartViewHolder (itemview: View): RecyclerView.ViewHolder(itemview){
        val productImage: ImageView = itemview.findViewById(R.id._product_picture)
        val productName: TextView = itemview.findViewById(R.id._product_name)
        val productDescription: TextView = itemview.findViewById(R.id._product_description)
        val productPrice: TextView = itemview.findViewById(R.id._product_price)
        val cartButton: ImageView = itemview.findViewById(R.id._add_to_cart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartViewHolder {
        val itemView = LayoutInflater.from(parent.context ).inflate(R.layout.product_card,parent,false)
        return cartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: cartViewHolder, position: Int) {
        val currentProduct = productList[position]
        holder.productImage.setImageResource(getImageResourse(currentProduct.productName))
        holder.productName.text = currentProduct.productName
        holder.productDescription.text = currentProduct.productDescription
        holder.productPrice.text = currentProduct.productPrice
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setData(cartProducts: List<product>){
        this.productList = cartProducts
        notifyDataSetChanged()
    }

    fun getImageResourse(name: String): Int{
        if (name == "Product One"){
            return R.drawable._product_one
        }
        else if (name == "Product Two"){
            return R.drawable._product_two
        }
        else{
            return R.drawable.product_three
        }
    }
}