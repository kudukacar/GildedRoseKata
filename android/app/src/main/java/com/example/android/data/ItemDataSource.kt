package com.example.android.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.android.BuildConfig
import com.example.android.model.Item
import java.util.*

class ItemDataSource(private val itemController: ItemController) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun fetchItems(): List<Item> {
        val username = BuildConfig.USERNAME
        val password = BuildConfig.PASSWORD
        return itemController
                .getItems("Basic " + Base64.getEncoder().encodeToString("$username:$password".toByteArray()))
    }
}