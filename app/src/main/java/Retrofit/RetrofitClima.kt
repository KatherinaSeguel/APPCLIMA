package Retrofit

import com.example.appclima.ApiClima
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClima {

    companion object{

        private const val URL_BASE = "https://api.gael.cl/general/public/clima"

        fun getRetroClima() : ApiClima {

            val mRetrofitClima = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofitClima.create(ApiClima::class.java)
        }
    }
}