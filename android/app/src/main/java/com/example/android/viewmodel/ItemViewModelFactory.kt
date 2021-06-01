package com.example.android.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.data.ItemDataSource

class ItemViewModelFactory(private val itemDataSource: ItemDataSource) : ViewModelProvider.NewInstanceFactory() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ItemViewModel(itemDataSource) as T
}