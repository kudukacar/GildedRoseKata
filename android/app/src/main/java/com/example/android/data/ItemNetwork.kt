package com.example.android.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ItemNetwork {
    val itemController by lazy {
        Retrofit
            .Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ItemController::class.java)
    }
}