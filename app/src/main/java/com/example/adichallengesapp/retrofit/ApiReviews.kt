package com.example.adichallengesapp.retrofit

import com.example.adichallengesapp.model.Review
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

interface ApiReviews {

    @GET("/reviews/{id}")
    fun getReviews(): Call<List<Review>>

    @POST("/reviews/{id}")
    fun addReview(@Body review: Review): Call<Review>
}
