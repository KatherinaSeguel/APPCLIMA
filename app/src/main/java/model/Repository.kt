package model

import Retrofit.RetrofitClima
import android.util.Log
import androidx.lifecycle.LiveData
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
        Log.d("mas", "saludo")
        val mCall = service.getClimaFromApi()
        mCall.enqueue(object : Callback<List<ClimaItem>> {
            override fun onResponse(
                call: Call<List<ClimaItem>>,
                response: Response<List<ClimaItem>>
            ) {
                Log.d("otro log", response.body().toString())
                when (response.code()) {

                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            Log.d("clima", it.toString())
                            mClimaDAO.insertAllClima(it)

                        }
                    }
                    in 300..399 -> Log.d("ERROR 300 ", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<List<ClimaItem>>, t: Throwable) {
                Log.d("error", t.message.toString())

            }

        })

    }

    fun getOneByCodigo(codigo: String): LiveData<ClimaItem>{
        return mClimaDAO.getCodigoByID(codigo)
    }

    fun getOneByEstado(estado: String): LiveData<ClimaItem>{
        return mClimaDAO.getEstadoByID(estado)
    }

    fun getOneByHora(horaUpdate: String): LiveData<ClimaItem>{
        return mClimaDAO.getHoraByID(horaUpdate)
    }

    fun getOneByTemperatura(temp: String): LiveData<ClimaItem>{
        return mClimaDAO.getTempByID(temp)
    }

    fun getOneByHumedad(humedad: String): LiveData<ClimaItem>{
        return mClimaDAO.getHumedadByID(humedad)
    }


}






