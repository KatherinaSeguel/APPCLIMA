package ui

import Adapter.Clima
import Adapter.ClimaAdapter
import MyViewModel.ClimaViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appclima.R
import kotlinx.android.synthetic.main.fragment_first.*
import model.ClimaItem


open class FirstFragment : Fragment(), Clima {

    lateinit var mClimaViewModel: ClimaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        mClimaViewModel = ViewModelProvider(this).get(ClimaViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mRecyclerView = recyclerView
        val mAdapter = ClimaAdapter(this)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)

        mClimaViewModel.mAllClima.observe(viewLifecycleOwner, Observer {
            mAdapter.updateListClima(it)
            Log.d("funciona", it.toString())

        })

    }

    override fun passClima(mClima: ClimaItem) {
        val mBundle = Bundle()
        mBundle.putString("codigo", mClima.codigo)
        mBundle.putString("estado", mClima.estado)
        mBundle.putString("Update", mClima.horaUpdate)
        mBundle.putString("Humedad", mClima.humedad)
        mBundle.putString("temperatura", mClima.temp)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, mBundle)
    }
}


