package com.example.adichallengesapp.retrofit

import com.example.adichallengesapp.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("/product")
    fun getProducts(): Call<List<Product>>


}