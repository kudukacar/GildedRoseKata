package com.example.android.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val sellIn: Int,
    val quality: Int,
    val name: String
): Parcelable
