package com.example.android.adapter

import com.example.android.R
import org.junit.Assert.*
import org.junit.Test

class ItemImageTest {
    @Test
    fun itReturnsTheCorrectImageId() {
        val itemImage = ItemImage
            .Builder()
            .addImage("AgedBrie", 1)
            .addImage("Normal", 2)
            .addImage("Conjured", 3)
            .build()
        assertEquals(2, itemImage.getImage("Normal"))
        assertEquals(1, itemImage.getImage("AgedBrie"))
        assertEquals(3, itemImage.getImage("Conjured"))
    }
}