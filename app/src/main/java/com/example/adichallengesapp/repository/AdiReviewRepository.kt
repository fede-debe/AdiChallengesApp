package com.example.adichallengesapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.adichallengesapp.model.Product
import com.example.adichallengesapp.model.Review
import com.example.adichallengesapp.retrofit.ApiInterface
import com.example.adichallengesapp.retrofit.ApiReviews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AdiReviewRepository {

    private var reviewsList: MutableLiveData<List<Review>> = MutableLiveData()

    private var BASE_URL = "http://192.168.68.102:3002"

    private var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(ApiReviews::class.java)

    fun getReviewsList(): MutableLiveData<List<Review>> {
        retrofit.getReviews().enqueue(object : Callback<List<Review>> {
            override fun onResponse(call: Call<List<Review>>, response: Response<List<Review>>) {
                reviewsList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Review>>, t: Throwable) {
                Log.i("onFailure", t.message.toString())
            }
        })
        return reviewsList
    }

    fun addReview(review: Review, onResult: (Review?) -> Unit){
        retrofit.addReview(review).enqueue(
            object : Callback<Review> {
                override fun onResponse(call: Call<Review>, response: Response<Review>) {
                    val addReviewBody = response.body()
                    onResult(addReviewBody)
                }

                override fun onFailure(call: Call<Review>, t: Throwable) {
                    onResult(null)
                }

            }
        )
    }
}