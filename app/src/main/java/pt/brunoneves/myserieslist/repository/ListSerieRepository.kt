package pt.brunoneves.myserieslist.repository

import pt.brunoneves.myserieslist.data.local.SeriesDatabase
import pt.brunoneves.myserieslist.data.model.Series

class ListSerieRepository constructor(
    private val database: SeriesDatabase
) {
    suspend fun addToList(seriesList: Series) = database.seriesListDao.insertSeries(seriesList)
    suspend fun getListSerie(seriesList: Series) = database.seriesListDao.getSeries()
    suspend fun checkSerie(id: String) = database.seriesListDao.checkSerie(id)
    suspend fun removeFromList(id: String) {
        database.seriesListDao.removeSeries(id)
    }
}
