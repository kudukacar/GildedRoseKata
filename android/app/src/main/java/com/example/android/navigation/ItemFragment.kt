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
        val itemName = binding.itemDetailName
        val itemQuality = binding.itemDetailQuality
        val itemSellin = binding.itemDetailSellin
        val item: Item = ItemFragmentArgs.fromBundle(requireArguments()).itemArgument
        itemName.text = item.name.uppercase()
        itemQuality.text = getString(R.string.item_quality, item.quality)
        itemSellin.text = getString(R.string.item_sellin, item.sellIn)
        return binding.root
    }
}