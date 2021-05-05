package com.example.adichallengesapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.adichallengesapp.retrofit.AdiReviewRepository
import com.example.adichallengesapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class ReviewsViewModel(private val adiReviewRepository: AdiReviewRepository): ViewModel() {

    fun getReviews() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = adiReviewRepository.getReviews()))
        } catch (exception: Exception){
            emit(Resource.error(data = null, message = exception.message ?: "Error occurred!"))
        }
    }

}