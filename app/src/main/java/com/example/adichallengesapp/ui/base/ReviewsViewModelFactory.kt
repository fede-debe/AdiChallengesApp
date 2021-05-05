package com.example.adichallengesapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adichallengesapp.retrofit.AdiReviewRepository
import com.example.adichallengesapp.retrofit.ApiReviewsHelper
import com.example.adichallengesapp.ui.main.ReviewsViewModel

class ReviewsViewModelFactory(private val apiReviewsHelper: ApiReviewsHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReviewsViewModel::class.java)){
            return ReviewsViewModel(AdiReviewRepository(apiReviewsHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}