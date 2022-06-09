package pt.brunoneves.myserieslist.ui.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pt.brunoneves.myserieslist.data.model.Series
import pt.brunoneves.myserieslist.network.SeriesNetwork

class SearchViewModel (app: Application) : AndroidViewModel(app) {
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
                return SearchViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    suspend fun getPopularSeries(): List<Series> {
        return SeriesNetwork.serie_service.getPopularSeries().results
    }

    suspend fun getSeriesByName(name: String?): List<Series> {
        return SeriesNetwork.serie_service.getSeriesByName().results
    }
}
