package com.example.myserieslist.network

import com.example.myserieslist.data.model.Series

data class SeriesResponse(
    val results: List<Series>
)
