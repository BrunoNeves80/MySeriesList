package com.example.myserieslist.data.remote

class ListSerieRepository constructor(
    private val seriesListDao: SeriesListDao
) {
    suspend fun addToList(seriesList: SeriesList) = SeriesListDao.addToList(seriesList)
    fun getListSerie() = SeriesListDao.getSeriesList()
    suspend fun checkSerie(id: String) = seriesListDao.checkSerie(id)
    suspend fun removeFromList(id: String) {
        seriesListDao.removeFromList(id)
    }
}