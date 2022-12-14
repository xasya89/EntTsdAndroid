package com.example.enttsd.viewmodels

import com.example.enttsd.models.LoginModel
import com.example.enttsd.models.NaryadModel
import retrofit2.Call
import retrofit2.http.*

interface EntApi {
    @POST("/api/login")
    @Headers("apikey: 12345")
    fun getLogin(@Body loginModel: LoginModel): Call<LoginModel>

    @GET("/api/naryad/search/{str}")
    @Headers("apikey: 12345")
    fun getNaryad(@Path("str") str:String):Call<ArrayList<NaryadModel>>
}