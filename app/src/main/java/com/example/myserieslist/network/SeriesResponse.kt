package com.example.myserieslist.network

import com.example.myserieslist.data.model.Serie
import com.example.myserieslist.data.remote.getDatabase


data class SeriesResponse (
    val results: List<Serie>
)