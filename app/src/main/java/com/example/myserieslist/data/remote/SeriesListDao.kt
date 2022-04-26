package com.example.myserieslist.data.remote

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SeriesListDao {
    @Insert
    suspend fun addToList(seriesList: SeriesList)

    @Query("SELECT * FROM SERIES_LIST")
    suspend fun getSeriesList(): LiveData<List<SeriesList>>

    @Query("SELECT count(*) FROM series_list WHERE series_list.id_Serie = :id ")
    suspend fun checkSerie(id: String) : Int

    @Query("DELETE FROM series_list WHERE series_list.id_Serie = :id")
    suspend fun removeFromList(id: String) : Int
}