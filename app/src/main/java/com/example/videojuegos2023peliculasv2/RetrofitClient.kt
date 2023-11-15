package com.example.videojuegos2023peliculasv2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://demo2054395.mockable.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val consultarApi = retrofit.create(ConsultarApi::class.java)
}