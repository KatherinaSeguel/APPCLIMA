package ui

import Adapter.ClimaAdapter
import MyViewModel.ViewModel
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

class FirstFragment : Fragment() {

    lateinit var mViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) //activar menu item
        mViewModel = ViewModelProvider(this).get(ViewModel::class.java)
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

        mViewModel.mAllClima.observe(viewLifecycleOwner, Observer {
            mAdapter.updateListClima(it)

        })
    }

    fun passClimas(mClimas: String){
        val mBundle = Bundle()
        mBundle.putString("clima", mClimas)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,mBundle)
    }

}
