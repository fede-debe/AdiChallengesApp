package com.example.adichallengesapp.retrofit

import com.example.adichallengesapp.model.Product
import retrofit2.http.GET

interface ApiProductsInterface {

    @GET("/product")
    suspend fun getProducts(): List<Product>


}