package com.example.a113zadaniebaseadaptersamochody

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    var imageId: Int,
    var name: String,
    var description: String
) : Parcelable