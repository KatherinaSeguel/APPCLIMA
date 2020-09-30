package Retrofit

import com.example.appclima.climaItem
import retrofit2.http.GET

interface ApiClima {

    @GET("/api.gael.cl/general/public/clima")

    fun getClimaFromApi(): retrofit2.Call<climaItem>
}

