package com.example.dhiwisepracticaltask.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val mainApiUrl = "https://api.figma.com/"
    // Initialize Retrofit instance lazily
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(mainApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Initialize API interface lazily
    val figmaApi by lazy {
        retrofit.create(FigmaApiInterface::class.java)
    }
}