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

    val series = seriesRepository.getSeriesList()

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
                return ListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
