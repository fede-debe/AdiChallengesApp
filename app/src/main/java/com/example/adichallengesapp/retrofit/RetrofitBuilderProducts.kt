package com.example.adichallengesapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderProducts {

    private const val BASE_URL = "http://192.168.68.102:3001"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiProducts: ApiProductsInterface = getRetrofit().create(ApiProductsInterface::class.java)
}