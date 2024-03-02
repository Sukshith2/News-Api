package com.example.headapinews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    lateinit var  recyclerView :RecyclerView
    lateinit var  adapater:MyAdapater



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            recyclerView = findViewById(R.id.recycler)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData= retrofit.getArticles("in","yours api keys")

        retrofitData.enqueue(object : Callback<Mydata?> {
            override fun onResponse(call: Call<Mydata?>, response: Response<Mydata?>) {
                var responseBody = response.body()
                val articlesList= responseBody?.articles
                val stringBuilder = StringBuilder()

                   adapater= MyAdapater(this@MainActivity, articlesList!!)
                    recyclerView.adapter=adapater
                        recyclerView.layoutManager= LinearLayoutManager(this@MainActivity)





            }

            override fun onFailure(call: Call<Mydata?>, t: Throwable) {
                Log.d("MainActivity", "OnFeiled to fetch the data" +t.message)


            }
        })








    }
}