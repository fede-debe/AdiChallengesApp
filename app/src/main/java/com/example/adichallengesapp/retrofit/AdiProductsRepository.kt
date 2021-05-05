package com.example.adichallengesapp.retrofit

class AdiProductsRepository(private val apiHelper: ApiProductsHelper) {

    suspend fun getProducts() = apiHelper.getProducts()

}