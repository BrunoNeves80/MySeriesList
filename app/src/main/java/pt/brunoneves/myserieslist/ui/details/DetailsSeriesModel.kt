package pt.brunoneves.myserieslist.ui.details

import androidx.lifecycle.ViewModel
import pt.brunoneves.myserieslist.data.model.Serie
import pt.brunoneves.myserieslist.repository.ListSerieRepository
import pt.brunoneves.myserieslist.data.remote.Series
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsSeriesModel constructor(
    private val repository: ListSerieRepository
    ) : ViewModel() {

//    fun addToList(serie: Serie) {
//        CoroutineScope(Dispatchers.IO).launch {
//            repository.addToList(
//                Series(
//                    serie.id,
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
