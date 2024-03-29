package pt.brunoneves.myserieslist.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "series")
@Parcelize
data class Series(
    @PrimaryKey
    val id: Int,
    val name: String,
    val overview: String?,
    val poster_path: String?,
    val first_air_date: String?,
    val vote_average: String,
) : Serializable, Parcelable
