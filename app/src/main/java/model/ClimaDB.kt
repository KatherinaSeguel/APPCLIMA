package model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appclima.Tiempo
import com.example.appclima.climaItem

private const val DATA_BASE_NAME="clima_db"

@Database(entities = [climaItem::class], version = 1)

abstract class ClimaDB : RoomDatabase() {

    abstract fun getClimaDAO(): climaDAO

    companion object {

        @Volatile
        private var INSTANCE: ClimaDB? = null

        fun getDataBase(context: Context): ClimaDB {

            val tempInterface = INSTANCE
            if (tempInterface != null) {
                return tempInterface
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ClimaDB::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance

            }
        }
    }
}
