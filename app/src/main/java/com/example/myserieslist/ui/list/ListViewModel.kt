package com.example.myserieslist.ui.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myserieslist.data.remote.getDatabase
import com.example.myserieslist.repository.ListSerieRepository

class ListViewModel(app: Application) : AndroidViewModel(app) {

    /**
     * The data source this ViewModel will fetch results from.
     */
    private val seriesRepository = ListSerieRepository(getDatabase(app))

    /**
     * Factory for constructing DevByteViewModel with parameter
     */
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            Log.i("qqq", "Factory")
            if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}