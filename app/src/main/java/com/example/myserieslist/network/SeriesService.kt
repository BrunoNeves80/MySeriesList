package com.example.myserieslist.network

import com.example.myserieslist.network.SeriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.StringReader

interface SeriesService {

    companion object{
        //instantiate variables to api location
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "87131f4b6436973f292f6ddfeb7e3a87"
    }

    @GET("tv/popular?api_key=$API_KEY")
    suspend fun getPopularSeries() : SeriesResponse

}