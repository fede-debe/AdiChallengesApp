package com.example.adichallengesapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adichallengesapp.model.Review
import com.example.adichallengesapp.repository.AdiReviewRepository

class ReviewsViewModel(): ViewModel() {

    private lateinit var adiReviewRepository: AdiReviewRepository
    var currentReview: Review? = null

    private var _reviewsList: MutableLiveData<List<Review>> = MutableLiveData()
    val reviewsList: LiveData<List<Review>>
        get() = _reviewsList

    private var _newReview: MutableLiveData<List<Review>> = MutableLiveData()
    val newReview: LiveData<List<Review>>
        get() = _newReview


    fun getReviewsList() {
        _reviewsList.value = adiReviewRepository.getReviewsList().value

    }

    fun setAdiReviewRepository(repository: AdiReviewRepository){
        adiReviewRepository = repository
    }

    fun saveReview(){
        val review = mutableListOf<Review>()

        _newReview.value?.let {
            review.addAll(it)
        }

        currentReview?.let {
            review.add(it)
        }

        _newReview.value = review
    }


}