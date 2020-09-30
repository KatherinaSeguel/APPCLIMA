package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import kotlinx.android.synthetic.main.clima.view.*
import model.ClimaItem
import model.Tiempo

class ClimaAdapter(var mPassClima : Clima): RecyclerView.Adapter<ClimaAdapter.TaskViewHolder>() {

    private var dataList = emptyList<Tiempo>()

    fun updateListClima(mDatalist: List<Tiempo>){

        dataList = mDatalist
        notifyDataSetChanged()
    }
    inner class TaskViewHolder (itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val climaName = itemView.tv_clima
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {
            mPassClima.passClima(dataList[adapterPosition].clima)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClimaAdapter.TaskViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.clima, parent, false )
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ClimaAdapter.TaskViewHolder, position: Int) {
        val mClima = dataList[position]
        holder.climaName.text = mClima.clima.toString()
    }

    override fun getItemCount() = dataList.size

}

interface Clima {

    fun passClima(mClima: ArrayList<ClimaItem>)

}