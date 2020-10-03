package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import kotlinx.android.synthetic.main.clima.view.*
import model.ClimaItem
import ui.FirstFragment

class ClimaAdapter(var mPassClima: FirstFragment): RecyclerView.Adapter<ClimaAdapter.TaskViewHolder>() {

    private var dataList = emptyList<ClimaItem>()

    fun updateListClima(mDatalist: List<ClimaItem>){

        dataList = mDatalist
        notifyDataSetChanged()
    }
    inner class TaskViewHolder (itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val climaName = itemView.tv_clima
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {
            mPassClima.passClima(dataList[adapterPosition])
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClimaAdapter.TaskViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.clima, parent, false )
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ClimaAdapter.TaskViewHolder, position: Int) {
        val mClima = dataList[position]
        holder.climaName.text = mClima.estacion



    }

    override fun getItemCount() = dataList.size

}

interface Clima {

    fun passClima(mClima: ClimaItem)

}