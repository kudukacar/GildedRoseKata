package com.example.android.data

import com.example.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ItemNetwork {
    val itemController by lazy {
        Retrofit
            .Builder()
            .baseUrl(BuildConfig.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ItemController::class.java)
    }
}