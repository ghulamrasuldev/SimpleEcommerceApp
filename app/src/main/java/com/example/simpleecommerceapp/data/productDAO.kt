package com.example.simpleecommerceapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface productDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addProductToCart (product: product)

    @Query ("SELECT * FROM productsInCard ORDER BY productPrice ASC")
    fun readAllData () : LiveData<List<product>>
}