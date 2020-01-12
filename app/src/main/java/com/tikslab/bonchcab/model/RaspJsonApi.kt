package com.tikslab.bonchcab.model

import com.tikslab.bonchcab.model.pojo.WeekTable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RaspJsonApi {
    @GET("/rasp")
    fun getRaspWithNum(
        @Query("week") num: Int,
        @Query("email") email: String,
        @Query("pass") pass: String
    ): Call<WeekTable>

    @GET("/rasp")
    fun logIn(
        @Query("email") email: String,
        @Query("pass") pass: String
    ): Call<Void>
}