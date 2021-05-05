package com.example.adichallengesapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderReviews {

    private var BASE_URL = "http://192.168.68.102:3002"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiReviews: ApiReviewsInterface = getRetrofit().create(ApiReviewsInterface::class.java)
}