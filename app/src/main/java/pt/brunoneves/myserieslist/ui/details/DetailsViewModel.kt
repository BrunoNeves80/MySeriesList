package pt.brunoneves.myserieslist.ui.details

import androidx.lifecycle.ViewModel
import pt.brunoneves.myserieslist.repository.ListSerieRepository

class DetailsViewModel constructor(
    private val repository: ListSerieRepository
) : ViewModel() {

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
