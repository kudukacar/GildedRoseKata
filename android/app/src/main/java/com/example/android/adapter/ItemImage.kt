package com.example.android.adapter

class ItemImage private constructor(val itemImages : MutableMap<String, Int>) {
    fun getImage(name: String) = itemImages[name]
    data class Builder(var itemImages: MutableMap<String, Int> = mutableMapOf()) {
        fun addImage(name: String, image:Int) = apply { this.itemImages.put(name, image) }
        fun build() = ItemImage(itemImages)
    }
}