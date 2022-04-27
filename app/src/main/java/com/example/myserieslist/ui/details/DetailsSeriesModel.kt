package com.example.myserieslist.ui.details

import androidx.lifecycle.ViewModel
import com.example.myserieslist.data.model.Serie
import com.example.myserieslist.repository.ListSerieRepository
import com.example.myserieslist.data.remote.Series
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsSeriesModel constructor(
    private val repository: ListSerieRepository
    ) : ViewModel() {

    fun addToList(serie: Serie) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addToList(
                Series(
                    serie.id,
                    serie.name,
                    serie.overview,
                    serie.poster_path,
                    serie.first_air_date,
                    serie.vote_average
                )
            )
        }
    }

    suspend fun checkSerie(id: String) = repository.checkSerie(id)

    fun removeFromList(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.removeFromList(id)
        }
    }
}
