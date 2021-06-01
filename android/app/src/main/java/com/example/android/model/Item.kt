package com.example.android.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val sellIn: Int,
    val quality: Int,
    val name: String
): Parcelable
