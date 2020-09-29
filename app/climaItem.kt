
import com.google.gson.annotations.SerializedName

data class climaItem(
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
    @SerializedName("Icono")
    val icono: String,
    @SerializedName("Temp")
    val temp: String
)