package com.example.batalla_naval_proyecto

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun getTablero(@Url url:String) : Call<tableroResponse>
}