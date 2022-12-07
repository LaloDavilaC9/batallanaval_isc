package com.example.batalla_naval_proyecto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Metodos {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://172.16.159.175:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}