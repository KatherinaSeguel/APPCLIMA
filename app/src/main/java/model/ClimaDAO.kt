package model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ClimaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllClima(mClimaList: List<ClimaItem>)

    @Query("SELECT * FROM clima_table")
    fun getAllClimaFromDB(): LiveData<List<ClimaItem>>

    @Query("SELECT * FROM clima_table WHERE id=:id" )
    fun getClimaByID(id: String): LiveData<ClimaItem>


}