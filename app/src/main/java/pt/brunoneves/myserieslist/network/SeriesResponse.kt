package pt.brunoneves.myserieslist.network

import pt.brunoneves.myserieslist.data.model.Series

data class SeriesResponse(
    val results: List<Series>
)
