package com.example.adichallengesapp.retrofit

class AdiReviewRepository (private val apiReviewsHelper: ApiReviewsHelper) {

    suspend fun getReviews() = apiReviewsHelper.getReviews()

}