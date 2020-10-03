package MyViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import model.ClimaDB
import model.ClimaItem
import model.Repository
import model.Tiempo


class ClimaViewModel(application: Application): AndroidViewModel(application){

    private val mRepository : Repository
    val mAllClima : LiveData<List<ClimaItem>>

    init {
        val mClimaDAO = ClimaDB.getDataBase(application).getClimaDAO()
        mRepository = Repository(mClimaDAO)
        mAllClima= mRepository.mTiempo
        mRepository.getTiempoFromServer()
    }

    fun getOneCodigo(codigo : String): LiveData<ClimaItem>{
        return mRepository.getOneByCodigo(codigo)
    }

    fun getOneHora(horaUpdate : String): LiveData<ClimaItem>{
        return mRepository.getOneByHora(horaUpdate)
    }

    fun getOneEstado(estado: String): LiveData<ClimaItem>{
        return mRepository.getOneByEstado(estado)
    }

    fun getOneTemperatura(temp: String): LiveData<ClimaItem>{
        return mRepository.getOneByTemperatura(temp)
    }

    fun getOneHumedad(humedad: String): LiveData<ClimaItem>{
        return mRepository.getOneByHumedad(humedad)
    }

}