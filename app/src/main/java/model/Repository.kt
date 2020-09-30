package model

import Retrofit.RetrofitClima
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.appclima.ClimaItem
import com.example.appclima.Tiempo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val mclimaDAO: ClimaDAO) {

    private val service = RetrofitClima.getRetroClima()
    val mLiveData = mclimaDAO.getAllClimaFromDB()

    fun obtainClimaByID(id: String): LiveData<ClimaItem> {

        return mclimaDAO.getClimaByID(id)
    }


}

