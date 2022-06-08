package pt.brunoneves.myserieslist.ui.list

import android.app.Application
import androidx.lifecycle.*
import pt.brunoneves.myserieslist.data.local.getDatabase
import pt.brunoneves.myserieslist.databinding.FragmentListBinding
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

    val series = seriesRepository.getSeriesList()

}

/* TODO(to delete if will not be used in the future tickets)
 val recyclerView: RecyclerView
  val emptyView: TextView

  recyclerView = rootView.findViewById(R.id.recycler_view)
  emptyView = rootView.findViewById(R.id.empty_view)


  if (SeriesDatabase.isEmpty()) {
      recyclerView.visibility = View.GONE
      emptyView.visibility = View.VISIBLE
  } else {
      recyclerView.visibility = View.VISIBLE
      emptyView.visibility = View.GONE
  }

 private val _properties = MutableLiveData<List<Series>>()

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
