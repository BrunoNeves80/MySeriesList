package pt.brunoneves.myserieslist.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pt.brunoneves.myserieslist.data.model.Series

@Dao
interface SeriesListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeries(series: Series)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeries(vararg series: Series?)

    @Query("SELECT * FROM series ORDER BY id DESC")
    fun getSeriesList(): LiveData<List<Series>>

    @Query("SELECT * FROM series WHERE series.id = :id ")
    suspend fun getSeries(id: String): Series

    @Query("DELETE FROM series WHERE series.id = :id")
    suspend fun deleteSeries(id: String): Int
}
