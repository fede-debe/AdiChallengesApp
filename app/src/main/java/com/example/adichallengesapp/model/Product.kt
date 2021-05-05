package com.example.adichallengesapp.model


data class Product(
    val id: String,
    val name: String,
    val description: String,
    val currency: String,
    val price: Int,
    val image: String,
    val reviews: List<Review>
)
