package model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appclima.climaItem

@Dao
interface climaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllClima(mClimaList: List<climaItem>)

    @Query("SELECT * FROM clima_table")
    fun getAllClimaFromDB(): LiveData<List<climaItem>>

    @Query("SELECT * FROM clima_table WHERE id=:id" )
    fun getClimaByID(id: String): LiveData<climaItem>


}