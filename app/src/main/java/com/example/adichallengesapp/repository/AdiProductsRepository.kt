package com.example.adichallengesapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.adichallengesapp.adapter.ProductListAdapter
import com.example.adichallengesapp.model.Product
import com.example.adichallengesapp.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AdiProductsRepository {

    private var productsList: MutableLiveData<List<Product>> = MutableLiveData()

    private var BASE_URL = "http://192.168.68.102:3001"

    private var retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build().create(ApiInterface::class.java)

    fun getProductsList(): MutableLiveData<List<Product>> {
        retrofit.getProducts().enqueue(object : Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                productsList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.i("onFailure", t.message.toString())
            }

        })

        return productsList
    }
}