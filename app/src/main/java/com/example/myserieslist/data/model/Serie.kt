package com.example.myserieslist.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//model of de database elements
@Parcelize
data class Serie(
    val id: String,
    val name: String,
    val overview: String?,
    val poster_path: String,
    val first_air_date: String,
    val vote_average: String
) : Parcelable {
    val baseUrl
        get() = ""
}
