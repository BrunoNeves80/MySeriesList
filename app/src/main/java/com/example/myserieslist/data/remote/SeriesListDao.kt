package com.example.myserieslist.data.remote

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SeriesListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToList(seriesList: Series)

    @Query("SELECT * FROM series ORDER BY first_air_date DESC")
    fun getSeriesList(): LiveData<List<Series>>

    @Query("SELECT * FROM series WHERE series.id_Serie = :id ")
    suspend fun checkSerie(id: String) : Series

    @Query("DELETE FROM series WHERE series.id_Serie = :id")
    suspend fun removeFromList(id: String) : Int
}