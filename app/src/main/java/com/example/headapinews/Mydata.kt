package com.example.headapinews

data class Mydata(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)