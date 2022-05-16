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

    fun addToList() {
        CoroutineScope(Dispatchers.IO).launch {
            seriesRepository.addToList(
                Series(
                    "2a",
                    "ze",
                    "milk",
                    "pacote",
                    "12345",
                    "0"
                )
            )
        }
    }

    fun checkSerie() {
        CoroutineScope(Dispatchers.IO).launch {
            val serie = seriesRepository.checkSerie("2a")
        }
    }

    fun removeFromList() {
        CoroutineScope(Dispatchers.IO).launch {
            seriesRepository.removeFromList("2a" )
        }
    }

    fun getListSerie() {
        CoroutineScope(Dispatchers.IO).launch {
            val seriesList = SeriesNetwork.serie_service.getPopularSeries()
        }
    }

}