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
import pt.brunoneves.myserieslist.network.SeriesNetwork

class ListViewModel(app: Application) : AndroidViewModel(app) {

    /**
     * The data source this ViewModel will fetch results from.
     */
    private val seriesRepository = ListSerieRepository(getDatabase(app))

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
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
