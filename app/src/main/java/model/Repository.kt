package model

import Retrofit.RetrofitClima
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val mClimaDAO: ClimaDAO) {

    private val service = RetrofitClima.getRetroClima()

    val mTiempo = mClimaDAO.getAllClimaFromDB()

    val mDataTiempoDBList = mutableListOf<Tiempo>()

    fun getTiempoFromServer() {

        val mCall = service.getClimaFromApi()
        mCall.enqueue(object : Callback<Tiempo>{
            override fun onResponse(call: Call<Tiempo>, response: Response<Tiempo>){
                when(response.code()){

                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            mClimaDAO.insertAllClima(it.clima)
                        }
                    }
                    in 300..399 -> Log.d("ERROR 300 ", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<Tiempo>, t: Throwable) {

            }

        })
    }
}





