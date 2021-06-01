package com.example.android.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.data.ItemDataSource
import com.example.android.model.Item
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.O)
class ItemViewModel(val itemDataSource: ItemDataSource) : ViewModel() {

    private val items =  MutableLiveData<List<Item>>()

    init {
        viewModelScope.launch {
            itemDataSource.fetchItems().enqueue(object: Callback<List<Item>> {
                override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                    items.postValue(response.body())
                }
                override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                }
            })
        }
    }

    fun getItems(): LiveData<List<Item>> {
        return items
    }
}