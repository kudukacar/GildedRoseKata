package com.example.android.data

import com.example.android.model.Item
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemDataSourceTest {
    @Test
    fun itFetchesAllItems() = runBlocking {
        val server = MockWebServer()
        val items : List<Item> = listOf(Item(0,0, "Normal"))
        val expectedResponse = """[{"sellIn": "0", "quality": "0", "name" : "Normal"}]"""
        server.enqueue(MockResponse().setBody(expectedResponse))
        server.start()
        val itemClient : ItemClient =
            Retrofit
                .Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ItemClient::class.java)

        val itemDataSource = ItemDataSource(itemClient)
        val response = itemDataSource.fetchItems()
        assertEquals(items, response)
    }
}