package com.example.headapinews

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {
    @GET("top-headlines")
    fun getArticles(
        @Query("country") country:String,
        @Query("apiKey") apiKey:String) :

            Call<Mydata>


}