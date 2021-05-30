package com.example.project2.Models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val title: String?,
    val image: String?,
    val streamCount: String?,
    val seasonCount: String?,
    val releaseDate: String?
): Parcelable {
    constructor(parcel: Parcel):this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
        ){}
}