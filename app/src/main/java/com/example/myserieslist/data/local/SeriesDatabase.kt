package com.example.myserieslist.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myserieslist.data.model.Series

@Database(entities = [Series::class], version = 1)
abstract class SeriesDatabase : RoomDatabase() {

    abstract val seriesListDao: SeriesListDao

}

private lateinit var INSTANCE: SeriesDatabase

fun getDatabase(context: Context): SeriesDatabase {
    synchronized(SeriesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                SeriesDatabase::class.java, "series_db"
            ).build()
        }
    }
    return INSTANCE
}
