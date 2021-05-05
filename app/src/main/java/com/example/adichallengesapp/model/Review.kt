package com.example.adichallengesapp.model

data class Review (
        val productId: String,
        val locale: String,
        val rating: Int,
        val text: String
)