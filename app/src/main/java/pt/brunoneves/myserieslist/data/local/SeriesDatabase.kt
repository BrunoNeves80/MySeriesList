package pt.brunoneves.myserieslist.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import pt.brunoneves.myserieslist.data.model.Series
import java.util.concurrent.Executors

@Database(entities = [Series::class], version = 2)
abstract class SeriesDatabase : RoomDatabase() {
    abstract val seriesListDao: SeriesListDao
}

private lateinit var INSTANCE: SeriesDatabase

fun getDatabase(context: Context): SeriesDatabase {
    synchronized(SeriesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                SeriesDatabase::class.java, "series_db"
            ).addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Executors.newSingleThreadScheduledExecutor().execute {
                        val series1 = Series(
                            id = 66732,
                            name = "Stranger Things",
                            overview = "When a young boy vanishes, a small town uncovers a mystery " +
                                    "involving secret experiments, terrifying supernatural forces, " +
                                    "and one strange little girl.",
                            first_air_date = "2022-03-24",
                            vote_average = "8.6",
                            poster_path = "/49WJfeN0moxb9IPfGn8AIqMGskD.jpg"
                        )
                        val series2 = Series(
                            id = 52814,
                            name = "Halo",
                            overview = "Depicting an epic 26th-century conflict between humanity and" +
                                    " an alien threat known as the Covenant, the series weaves deeply" +
                                    " drawn personal stories with action, adventure and a richly " +
                                    "imagined vision of the future.",
                            first_air_date = "2003-10-21",
                            vote_average = "8.6",
                            poster_path = "/eO0QV5qJaEngP1Ax9w3eV6bJG2f.jpg",
                        )
                        val series3 = Series(
                            id = 76479,
                            name = "The Boys",
                            overview = "A group of vigilantes known informally as “The Boys” set out" +
                                    " to take down corrupt superheroes with no more than blue-collar" +
                                    " grit and a willingness to fight dirty.",
                            first_air_date = "2022-06-08",
                            vote_average = "8.4",
                            poster_path = "/stTEycfG9928HYGEISBFaG1ngjM.jpg",
                        )
                        INSTANCE.seriesListDao.insertSeries(series1, series2, series3)
                    }

                }

                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    INSTANCE
                }
            }).fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}
