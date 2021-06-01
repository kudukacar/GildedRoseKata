package com.example.android.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.data.ItemClient
import com.example.android.data.ItemDataSource
import com.example.android.model.Item
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)
@RunWith(AndroidJUnit4::class)
class ItemViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    @Test
    fun itGetsAllItems() {
        val server = MockWebServer()
        val items : List<Item> = listOf(Item(0,0, "Normal"))
        val response = """[{"sellIn": "0", "quality": "0", "name" : "Normal"}]"""
        server.enqueue(MockResponse().setBody(response))
        server.start()
        val itemClient : ItemClient =
            Retrofit
                .Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ItemClient::class.java)

        val itemDataSource = ItemDataSource(itemClient)
        val itemViewModel = ItemViewModel(itemDataSource)
        val observer: Observer<List<Item>> = mock()
        itemViewModel.getItems().observeForever(observer)
        val captor = ArgumentCaptor.forClass(Item::class.java)
        captor.run {
            verify(observer, times(1)).onChanged(listOf(capture()))
            assertEquals(items, value)
        }
    }
}
