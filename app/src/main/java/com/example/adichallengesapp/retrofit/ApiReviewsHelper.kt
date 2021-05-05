package com.example.adichallengesapp.retrofit

class ApiReviewsHelper(private val apiReviews: ApiReviewsInterface) {
    suspend fun getReviews() = apiReviews.getReviews()
}