package com.example.adichallengesapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adichallengesapp.model.Product
import com.example.adichallengesapp.repository.AdiProductsRepository

class ProductsListViewModel(): ViewModel() {

    private lateinit var adiRepository: AdiProductsRepository

    private var _productsList: MutableLiveData<List<Product>> = MutableLiveData()
    val productList: LiveData<List<Product>>
        get() = _productsList


    fun getProductList() {
        _productsList.value = adiRepository.getProductsList().value

    }

    fun setAdiRepository(repository: AdiProductsRepository){
        adiRepository = repository
    }

}