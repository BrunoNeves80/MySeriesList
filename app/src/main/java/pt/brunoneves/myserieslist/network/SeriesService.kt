package pt.brunoneves.myserieslist.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SeriesService {

    companion object {
        //instantiate variables to api location
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "87131f4b6436973f292f6ddfeb7e3a87"
    }

    @GET("tv/popular?api_key=$API_KEY")
    suspend fun getPopularSeries(): SeriesResponse

    @GET("search/tv?api_key=$API_KEY")
    suspend fun getSeriesByName(@Query("query") name: String?): SeriesResponse

    @GET("tv/{tv_id}?api_key=$API_KEY")
    suspend fun getDetailSeries(@Path("tv_id") id: Int): SeriesDetailsResponse
}
