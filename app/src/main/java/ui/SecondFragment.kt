package ui


import MyViewModel.ClimaViewModel
import android.net.sip.SipSession
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appclima.R
import kotlinx.android.synthetic.main.fragment_second.*



class SecondFragment : Fragment() {


    lateinit var  mClimaViewModel: ClimaViewModel
    private var idDato: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mClimaViewModel = ViewModelProvider(this).get(ClimaViewModel::class.java)
        arguments?.let {
            idDato = it.getString("codigo")
            Log.d("OBJ", idDato.toString())
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idDato?.let {
            mClimaViewModel.getOneCodigo(it).observe(viewLifecycleOwner, Observer {
                Log.d("OBJ_LIV", it.codigo)
                textView.setText(it.codigo)
                Log.d("OBJ_LIV", it.horaUpdate)
                textView2.setText(it.horaUpdate)
                Log.d("OBJ_LIV", it.estado)
                textView3.setText(it.estado)
                Log.d("OBJ_LIV", it.temp)
                textView4.setText(it.temp)
                Log.d("OBJ_LIV", it.humedad)
                textView5.setText(it.humedad)


            })

        }

        button.setOnClickListener{

                        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                }


        }

    }
