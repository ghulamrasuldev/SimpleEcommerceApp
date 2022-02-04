package com.example.simpleecommerceapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [product::class], version = 1, exportSchema = false)
abstract class cartDatabase: RoomDatabase(){
    abstract fun productDAO(): productDAO

    companion object{
        @Volatile
        private var INSTANCE: cartDatabase? = null

        fun getDatabase(context: Context) : cartDatabase {
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    cartDatabase::class.java,
                    "productsInCard"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}