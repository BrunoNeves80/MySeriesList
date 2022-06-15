package pt.brunoneves.myserieslist.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pt.brunoneves.myserieslist.data.model.Series
import pt.brunoneves.myserieslist.repository.ListSerieRepository

class DetailsViewModel (series: Series, app : Application) : AndroidViewModel(app) {


    private val _navigateToSelectedItem = MutableLiveData<Series>()
    val navigateToSelectedItem :LiveData<Series>
        get() = _navigateToSelectedItem

    fun displaySeriesDetails(series: Series) {
        _navigateToSelectedItem.value = series
    }

//    fun addToList(serie: Serie) {
//        CoroutineScope(Dispatchers.IO).launch {
//            repository.addToList(
//                Series(
//                    serie.name,
//                    serie.overview,
//                    serie.poster_path,
//                    serie.first_air_date,
//                    serie.vote_average
//                )
//            )
//        }
//    }
//
//    suspend fun checkSerie(id: String) = repository.checkSerie(id)
//
//    fun removeFromList(id: String) {
//        CoroutineScope(Dispatchers.IO).launch {
//            repository.removeFromList(id)
//        }
//    }
}
