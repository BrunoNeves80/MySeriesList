package pt.brunoneves.myserieslist.ui.list

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.brunoneves.myserieslist.data.local.SeriesListDao
import pt.brunoneves.myserieslist.data.local.getDatabase
import pt.brunoneves.myserieslist.data.model.Series
import pt.brunoneves.myserieslist.databinding.FragmentListBinding
import pt.brunoneves.myserieslist.network.SeriesNetwork
import pt.brunoneves.myserieslist.repository.ListSerieRepository

class ListViewModel(app: Application) : AndroidViewModel(app) {

    private lateinit var binding: FragmentListBinding
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

    init {

    }

    val series = seriesRepository.getSeriesList()

   /* private val _properties = MutableLiveData<List<Series>>()

    val properties : LiveData<List<Series>>
        get() = _properties


   *//* private fun getSeriesProperties(filter: SeriesNetwork) {
        viewModelScope.launch {
            try {
                _properties.value = SeriesNetwork.serie_service.getPopularSeries()
            } catch (e : Exception) {
                _properties.value
            }
        }
    }*//*
*/
   fun displayList() {

       val list = listOf<Series>()
       if (list.isEmpty()) {
           binding.recyclerViewSerie.visibility = View.GONE
           binding.emptyList.visibility = View.VISIBLE
       } else {
           binding.recyclerViewSerie.visibility = View.VISIBLE
           binding.emptyList.visibility = View.GONE
       }
   }

    fun getListSerie() {
        CoroutineScope(Dispatchers.IO).launch {
            SeriesNetwork.serie_service.getPopularSeries()
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

}
