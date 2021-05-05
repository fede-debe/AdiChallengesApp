package com.example.adichallengesapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adichallengesapp.retrofit.AdiProductsRepository
import com.example.adichallengesapp.retrofit.ApiProductsHelper
import com.example.adichallengesapp.ui.main.ProductsListViewModel
import java.lang.IllegalArgumentException

class ProductsListViewModelFactory(private val apiHelper: ApiProductsHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsListViewModel::class.java)){
            return ProductsListViewModel(AdiProductsRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}