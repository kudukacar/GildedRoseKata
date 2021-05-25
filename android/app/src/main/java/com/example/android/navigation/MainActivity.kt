package com.example.android.navigation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.android.R
import com.example.android.data.ItemDataSource
import com.example.android.data.ItemNetwork
import com.example.android.databinding.ActivityMainBinding
import com.example.android.model.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val textView: TextView = binding.textView
        val itemDataSource = ItemDataSource(ItemNetwork.itemController)
        itemDataSource.fetchItems().enqueue(object: Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                textView.text = response.body()?.size.toString()
            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
            }

        })
    }
}
