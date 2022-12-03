package com.example.batalla_naval_proyecto

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getTablero(@Url url:String) : Call<posicionResponse>

    @GET
    suspend fun preguntarPosicion(@Url url:String) : Response<posicionResponse>

    @POST("/atacarCelda")
    suspend fun atacar(@Body requestBody: RequestBody) : Response<ResponseBody>

}