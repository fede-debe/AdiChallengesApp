package com.example.adichallengesapp.retrofit

import com.example.adichallengesapp.model.Review
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiReviewsInterface {

    @GET("/reviews/{id}")
    suspend fun getReviews(): List<Review>

    @POST("/reviews/{id}")
    fun addReview(@Body review: Review): Call<Review>
}
