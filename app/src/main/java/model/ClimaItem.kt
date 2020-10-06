package model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "clima_table")
data class ClimaItem(
    @PrimaryKey
    @SerializedName("Codigo")
    val codigo: String,
    @SerializedName("Estacion")
    val estacion: String,
    @SerializedName("Estado")
    val estado: String,
    @SerializedName("HoraUpdate")
    val horaUpdate: String,
    @SerializedName("Humedad")
    val humedad: String,
    @SerializedName("Temp")
    val temp: String

)