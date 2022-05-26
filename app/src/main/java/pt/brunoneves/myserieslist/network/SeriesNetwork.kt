package pt.brunoneves.myserieslist.network

import pt.brunoneves.myserieslist.network.SeriesService.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object SeriesNetwork {
    //added moshi to converter objects
    // adapter
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    val serie_service: SeriesService = retrofit.create(SeriesService::class.java)
}
