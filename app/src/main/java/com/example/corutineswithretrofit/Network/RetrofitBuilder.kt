package com.example.corutineswithretrofit.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Url.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : APi by lazy{
        retrofit.create(APi::class.java)
    }

}