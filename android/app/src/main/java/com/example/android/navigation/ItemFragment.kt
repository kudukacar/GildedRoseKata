package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.R
import com.example.android.databinding.FragmentItemBinding
import com.example.android.model.Item

class ItemFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentItemBinding>(inflater,
            R.layout.fragment_item, container, false)
        val item_name = binding.itemDetailName
        val item_quality = binding.itemDetailQuality
        val item_sellin = binding.itemDetailSellin
        val item: Item = ItemFragmentArgs.fromBundle(requireArguments()).itemArgument
        item_name.text = item.name
        item_quality.text = item.quality.toString()
        item_sellin.text = item.sellIn.toString()
        return binding.root
    }
}