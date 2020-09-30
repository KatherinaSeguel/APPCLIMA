package Retrofit

import com.example.appclima.Tiempo
import retrofit2.Response
import retrofit2.http.GET

interface ApiClima {

    @GET("/api.gael.cl/general/public/clima")

    fun getClimaFromApi(): retrofit2.Call<Tiempo>

    @GET("realestate")
    suspend fun getDataFromApiCorutines() : Response<List<Tiempo>>
}

