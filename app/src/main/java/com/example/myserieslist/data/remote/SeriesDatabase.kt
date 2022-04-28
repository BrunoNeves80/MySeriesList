package com.example.myserieslist.data.remote

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Series::class], version = 1)
abstract class SeriesDatabase : RoomDatabase(){

    abstract val seriesListDao : SeriesListDao

}

private lateinit var INSTANCE: SeriesDatabase

fun getDatabase(context: Context): SeriesDatabase {
    Log.i("qqq", "database")
    synchronized(SeriesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                SeriesDatabase::class.java, "series_db").build()
        }
    }
    return INSTANCE
}