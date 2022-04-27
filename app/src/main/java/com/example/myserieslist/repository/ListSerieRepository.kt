package com.example.myserieslist.repository

import com.example.myserieslist.data.remote.Series
import com.example.myserieslist.data.remote.SeriesListDao

class ListSerieRepository constructor(
    private val seriesListDao: SeriesListDao
) {
    suspend fun addToList(seriesList: Series) = seriesListDao.addToList(seriesList)
    suspend fun getListSerie() = seriesListDao.getSeriesList()
    suspend fun checkSerie(id: String) = seriesListDao.checkSerie(id)
    suspend fun removeFromList(id: String) {
        seriesListDao.removeFromList(id)
    }
}