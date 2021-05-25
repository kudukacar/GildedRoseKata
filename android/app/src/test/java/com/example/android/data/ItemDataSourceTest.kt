package com.example.android.data

import com.example.android.model.Item
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.json.JSONArray
import org.junit.Test
import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ItemDataSourceTest {
    @Test
    fun itFetchesAllItems() {
        val server = MockWebServer()
        val items : List<Item> = listOf(Item(0,0, "Normal"))
        val expectedResponse = """[{"sellIn": "0", "quality": "0", "name" : "Normal"}]"""
        server.enqueue(MockResponse().setBody(expectedResponse))
        server.start()
        val itemController : ItemController =
            Retrofit
                .Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ItemController::class.java)

        val itemDataSource = ItemDataSource(itemController)
        val response = itemDataSource.fetchItems().execute().body()
        assertEquals(items, response)
    }


}