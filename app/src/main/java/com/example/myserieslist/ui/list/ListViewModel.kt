package com.example.myserieslist.ui.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.myserieslist.data.remote.Series
import com.example.myserieslist.data.remote.getDatabase
import com.example.myserieslist.network.SeriesNetwork
import com.example.myserieslist.repository.ListSerieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(app: Application) : AndroidViewModel(app) {

    /**
     * The data source this ViewModel will fetch results from.
     */
    private val seriesRepository = ListSerieRepository(getDatabase(app))

    /**
     * Factory for constructing DevByteViewModel with parameter
     */
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            Log.i("qqq", "Factory")
            if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    /*TODO("This code bellow was used for testing but maybe
       it will be used in the future")
    with some changes")
    fun addToList(series: Series) {
        CoroutineScope(Dispatchers.IO).launch {
            seriesRepository.addToList(
                Series(
                    series.id_Serie,
                    series.name,
                    series.overview,
                    series.poster_path,
                    series.first_air_date,
                    series.vote_average
                )
            )
        }
    }

    fun checkSerie(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            seriesRepository.checkSerie(id)
        }
    }

    fun removeFromList(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            seriesRepository.removeFromList(id)
        }
    }*/

    fun getListSerie() {
        CoroutineScope(Dispatchers.IO).launch {
            SeriesNetwork.serie_service.getPopularSeries()
        }
    }

}