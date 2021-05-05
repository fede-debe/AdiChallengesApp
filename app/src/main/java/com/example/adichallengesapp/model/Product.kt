package com.example.adichallengesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_list_table")
data class Product(

        @PrimaryKey(autoGenerate = false)
        var id: String = "",
        @ColumnInfo(name = "name")
        var name: String = "",
        @ColumnInfo(name = "description")
        var description: String = "",
        @ColumnInfo(name = "currency")
        var currency: String = "",
        @ColumnInfo(name = "price")
        var price: Int = 0,
        @ColumnInfo(name = "img_url")
        var imgUrl: String = "",
        @ColumnInfo(name = "reviews")
        var reviews: List<Review> = mutableListOf()
)
