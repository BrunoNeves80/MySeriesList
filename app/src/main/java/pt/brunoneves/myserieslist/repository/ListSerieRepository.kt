package pt.brunoneves.myserieslist.repository

import pt.brunoneves.myserieslist.data.remote.Series
import pt.brunoneves.myserieslist.data.remote.SeriesDatabase

class ListSerieRepository constructor(
    private val database: SeriesDatabase
) {
    suspend fun addToList(seriesList: Series) = database.seriesListDao.addToList(seriesList)
    suspend fun getListSerie(seriesList: Series) = database.seriesListDao.getSeriesList()
    suspend fun checkSerie(id: String) = database.seriesListDao.checkSerie(id)
    suspend fun removeFromList(id: String) {
        database.seriesListDao.removeFromList(id)
    }
}
