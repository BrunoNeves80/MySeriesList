package com.example.myserieslist.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SeriesNetwork {

    private val retrofit : Retrofit =
        Retrofit.Builder()
            .baseUrl(SeriesService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    val SERIE_SERVICE: SeriesService = retrofit.create(SeriesService::class.java)
}

