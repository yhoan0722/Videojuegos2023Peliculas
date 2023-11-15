package com.example.videojuegos2023peliculasv2

import retrofit2.Call
import retrofit2.http.GET

interface ConsultarApi {
    @GET("pelicula")
    fun getTraer(): Call<Pelicula>
}