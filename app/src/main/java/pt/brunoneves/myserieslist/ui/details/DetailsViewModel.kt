package pt.brunoneves.myserieslist.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import pt.brunoneves.myserieslist.data.local.getDatabase
import pt.brunoneves.myserieslist.network.SeriesDetailsResponse
import pt.brunoneves.myserieslist.repository.ListSerieRepository

class DetailsViewModel (app: Application) : AndroidViewModel(app) {
    private val seriesRepository = ListSerieRepository(getDatabase(app))

    suspend fun getSeriesDetails(id: Int): SeriesDetailsResponse {
        return seriesRepository.getSeriesDetails(id)
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
