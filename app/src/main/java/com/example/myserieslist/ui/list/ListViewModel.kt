package com.example.myserieslist.ui.list

import androidx.lifecycle.ViewModel
import com.example.myserieslist.repository.ListSerieRepository

class ListViewModel constructor(
    private val repository: ListSerieRepository
) : ViewModel() {
}