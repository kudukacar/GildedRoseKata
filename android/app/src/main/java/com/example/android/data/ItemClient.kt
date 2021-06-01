package com.example.android.data
import com.example.android.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ItemClient {
    @GET("items")
    fun getItems(@Header("Authorization") authorization: String): Call<List<Item>>
}