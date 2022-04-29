package com.example.myserieslist.network

import com.example.myserieslist.data.model.Serie
import com.example.myserieslist.data.remote.getDatabase
import com.google.gson.annotations.JsonAdapter

data class SeriesResponse (
    val results: List<Serie>
)