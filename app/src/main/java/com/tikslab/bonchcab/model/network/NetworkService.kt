package com.tikslab.bonchcab.model.network

import com.tikslab.bonchcab.model.network.api.TableJsonApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object NetworkService {

    val TABLE_API: TableJsonApi
    private val mRetrofit: Retrofit

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
        TABLE_API = mRetrofit.create(
            TableJsonApi::class.java)
    }
}