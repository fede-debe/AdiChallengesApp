package com.example.adichallengesapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.adichallengesapp.retrofit.AdiProductsRepository
import com.example.adichallengesapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class ProductsListViewModel(private val adiProductsRepository: AdiProductsRepository): ViewModel() {

    fun getProducts() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = adiProductsRepository.getProducts()))
        } catch (exception: Exception){
            emit(Resource.error(data = null, message = exception.message ?: "Error occurred!"))
        }
    }


}