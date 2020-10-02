package Retrofit

import model.ClimaItem
import model.Tiempo
import retrofit2.Response
import retrofit2.http.GET

interface ApiClima {

    @GET("clima/")
    fun getClimaFromApi(): retrofit2.Call<List<ClimaItem>>

    @GET("clima/")
    suspend fun getDataFromApiCorutines() : Response<List<ClimaItem>>
}

