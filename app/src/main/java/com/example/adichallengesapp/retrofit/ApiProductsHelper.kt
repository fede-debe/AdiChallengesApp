package com.example.adichallengesapp.retrofit

class ApiProductsHelper(private val apiProductsInterface: ApiProductsInterface) {
    suspend fun getProducts() = apiProductsInterface.getProducts()
}