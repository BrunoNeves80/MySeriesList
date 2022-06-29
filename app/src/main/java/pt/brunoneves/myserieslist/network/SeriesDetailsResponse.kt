package pt.brunoneves.myserieslist.network

data class SeriesDetailsResponse(
    val id: Int,
    val name: String,
    val overview: String?,
    val poster_path: String?,
    val first_air_date: String?,
    val vote_average: String,
    val number_of_episodes: String,
    val number_of_seasons: String
)