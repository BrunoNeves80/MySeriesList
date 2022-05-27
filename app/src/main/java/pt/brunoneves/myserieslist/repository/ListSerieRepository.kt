package pt.brunoneves.myserieslist.repository

import pt.brunoneves.myserieslist.data.local.SeriesDatabase
import pt.brunoneves.myserieslist.data.model.Series

class ListSerieRepository constructor(
    private val database: SeriesDatabase
) {
    suspend fun insertSeries(series: Series) = database.seriesListDao.insertSeries(series)
    suspend fun getSeriesList(series: Series) = database.seriesListDao.getSeriesList()
    suspend fun getSeries(id: String) = database.seriesListDao.getSeries(id)
    suspend fun deleteSeries(id: String) {
        database.seriesListDao.deleteSeries(id)
    }
}
