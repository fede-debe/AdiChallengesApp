package com.example.adichallengesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.adichallengesapp.model.Product

@Dao
interface ProductDatabaseDao {

    @Query("SELECT * FROM products_list_table ORDER BY id DESC")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("SELECT * from products_list_table WHERE id = :key")
    suspend fun get(key: String): Product
}