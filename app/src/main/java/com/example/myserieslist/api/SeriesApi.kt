package com.example.myserieslist.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SeriesApi {

    companion object{
        //instantiate variables to api location
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "87131f4b6436973f292f6ddfeb7e3a87"
    }

    @GET("tv/popular")
    fun getPopularSeries(
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<SeriesResponse>

}