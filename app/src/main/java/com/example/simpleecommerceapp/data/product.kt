package com.example.simpleecommerceapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "productsInCard")
data class product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val productName: String,
    val productDescription: String,
    val productPrice: String
)