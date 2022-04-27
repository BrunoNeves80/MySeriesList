package com.example.myserieslist.data.remote

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Series::class], version = 1, exportSchema = false)
abstract class ListSeriesDatabase : RoomDatabase(){

    abstract fun getSerieListDao() : SeriesListDao
}
