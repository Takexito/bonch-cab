package com.tikslab.bonchcab.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object NetworkService {

    val raspApi: RaspJsonApi
    val mRetrofit: Retrofit

    init{
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .build()

        mRetrofit = Retrofit.Builder()
            .baseUrl("https://bonch-cab.herokuapp.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        raspApi = mRetrofit.create(RaspJsonApi::class.java)
    }
}