package com.example.simpleecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.StringRequest
import com.example.simpleecommerceapp.data.cartViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.simpleecommerceapp.common.dummy_text
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mCartViewModel = ViewModelProvider(this).get(cartViewModel::class.java)
        val productList = jsonParse()
        val productView : RecyclerView = findViewById(R.id._products)
        productView.adapter = ProductsAdaptor(productList, mCartViewModel)
        productView.layoutManager =  LinearLayoutManager(this)

        findViewById<ImageView>(R.id._view_cart).setOnClickListener{
            val intent = Intent(this, CartScreen::class.java)
            startActivity(intent)
        }

    }

    private fun jsonParse() : ArrayList<productItem>{
        val list = ArrayList<productItem>()
        var productName:String
        var productPrice: String
        var requestQueue: RequestQueue? = null
        requestQueue = Volley.newRequestQueue(this)
        val url = "https://www.themealdb.com/api/json/v1/1/filter.php?a=Canadian"
        val request = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {
                response ->try {
            val jsonArray = response.getJSONArray("meals")
            Log.d("test", "$jsonArray")
            for (meal in 0 until jsonArray.length()) {
                val employee = jsonArray.getJSONObject(meal)
                productName = employee.getString("strMeal")
                productPrice = employee.getString("idMeal")
                list.add(productItem(getImageResourse(),R.drawable._add_to_cart_icon, productName, dummy_text, productPrice))
                Log.d("test", "$productName, $productPrice")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)
        return  list
    }

    fun getImageResourse(): Int{
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



    private fun dummyData (): List<productItem>{
        val list = ArrayList<productItem>()
        list.add(productItem(R.drawable._product_one, R.drawable._add_to_cart_icon, "Product One", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "300"))
        list.add(productItem(R.drawable._product_two, R.drawable._add_to_cart_icon, "Product Two", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "400"))
        list.add(productItem(R.drawable.product_three, R.drawable._add_to_cart_icon, "Product Three", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "500"))
        list.add(productItem(R.drawable._product_one, R.drawable._add_to_cart_icon, "Product One", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "300"))
        list.add(productItem(R.drawable._product_two, R.drawable._add_to_cart_icon, "Product Two", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "400"))
        list.add(productItem(R.drawable.product_three, R.drawable._add_to_cart_icon, "Product Three", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "500"))
        list.add(productItem(R.drawable._product_one, R.drawable._add_to_cart_icon, "Product One", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "300"))
        list.add(productItem(R.drawable._product_two, R.drawable._add_to_cart_icon, "Product Two", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "400"))
        list.add(productItem(R.drawable.product_three, R.drawable._add_to_cart_icon, "Product Three", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "500"))
        list.add(productItem(R.drawable._product_one, R.drawable._add_to_cart_icon, "Product One", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "300"))
        list.add(productItem(R.drawable._product_two, R.drawable._add_to_cart_icon, "Product Two", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "400"))
        list.add(productItem(R.drawable.product_three, R.drawable._add_to_cart_icon, "Product Three", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "500"))
        list.add(productItem(R.drawable._product_one, R.drawable._add_to_cart_icon, "Product One", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "300"))
        list.add(productItem(R.drawable._product_two, R.drawable._add_to_cart_icon, "Product Two", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "400"))
        list.add(productItem(R.drawable.product_three, R.drawable._add_to_cart_icon, "Product Three", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "500"))
        list.add(productItem(R.drawable._product_one, R.drawable._add_to_cart_icon, "Product One", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "300"))
        list.add(productItem(R.drawable._product_two, R.drawable._add_to_cart_icon, "Product Two", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "400"))
        list.add(productItem(R.drawable.product_three, R.drawable._add_to_cart_icon, "Product Three", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.", "500"))
        return list
    }
}