package com.example.android.navigation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.android.R
import com.example.android.adapter.ItemAdapter
import com.example.android.adapter.ItemImage
import com.example.android.data.ItemDataSource
import com.example.android.data.ItemNetwork
import com.example.android.databinding.FragmentItemsBinding
import kotlinx.coroutines.launch

class ItemsFragment : Fragment() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentItemsBinding>(inflater,
            R.layout.fragment_items, container, false)
        val recyclerView = binding.recyclerView
        val itemDataSource = ItemDataSource(ItemNetwork.itemClient)
        val itemImage = ItemImage
            .Builder()
            .addImage("AgedBrie", R.drawable.agedbrie)
            .addImage("Normal", R.drawable.normal)
            .addImage("Conjured", R.drawable.conjured)
            .addImage("Sulfuras", R.drawable.sulfuras)
            .addImage("BackstagePasses", R.drawable.backstage)
            .build()
        lifecycleScope.launch {
            val items = itemDataSource.fetchItems()
            recyclerView.adapter = ItemAdapter(itemImage, items) { item ->
                view?.findNavController()
                    ?.navigate(ItemsFragmentDirections.actionItemsFragmentToItemFragment(item))
            }
        }
        return binding.root
    }
}