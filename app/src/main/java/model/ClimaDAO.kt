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

    @Query("SELECT * FROM clima_table WHERE clima=:clima" )
    fun getClimaByID(clima: String): LiveData<ClimaItem>

    @Query("SELECT * FROM clima_table WHERE codigo=:codigo" )
    fun getCodigoByID(codigo: String): LiveData<ClimaItem>

    @Query("SELECT * FROM clima_table WHERE horaUpdate=:horaUpdate" )
    fun getHoraByID(horaUpdate: String): LiveData<ClimaItem>

    @Query("SELECT * FROM clima_table WHERE estado=:estado" )
    fun getEstadoByID(estado: String): LiveData<ClimaItem>


    @Query("SELECT * FROM clima_table WHERE temp=:temp" )
    fun getTempByID(temp: String): LiveData<ClimaItem>

    @Query("SELECT * FROM clima_table WHERE humedad=:humedad" )
    fun getHumedadByID(humedad: String): LiveData<ClimaItem>

}