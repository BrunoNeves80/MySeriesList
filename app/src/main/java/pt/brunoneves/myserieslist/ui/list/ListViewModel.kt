package pt.brunoneves.myserieslist.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pt.brunoneves.myserieslist.repository.ListSerieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.brunoneves.myserieslist.data.local.getDatabase
import pt.brunoneves.myserieslist.data.model.Series
import pt.brunoneves.myserieslist.network.SeriesNetwork

class ListViewModel(app: Application) : AndroidViewModel(app) {

    /**
     * The data source this ViewModel will fetch results from.
     */
    private val seriesRepository = ListSerieRepository(getDatabase(app))

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
                return ListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }


    fun addToList() {
        CoroutineScope(Dispatchers.IO).launch {
            seriesRepository.insertSeries(
                Series(
                    name = "Ze Malha",
                    overview = "Camarinha",
                    poster_path = "12",
                    first_air_date = "12345",
                    vote_average =  "2222"
                )
            )
        }
    }

    fun checkSerie(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            seriesRepository.getSeries(id)
        }
    }
/*
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
