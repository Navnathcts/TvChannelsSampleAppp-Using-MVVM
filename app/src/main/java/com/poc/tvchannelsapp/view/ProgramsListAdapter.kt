package com.azhar.weatherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poc.tvchannelsapp.R
import com.poc.tvchannelsapp.model.ProgramListModel
import kotlinx.android.synthetic.main.programs_list_item.view.*

class ProgramsListAdapter(private val programsList: MutableList<ProgramListModel?>?) :
    RecyclerView.Adapter<ProgramsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.programs_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        programsList?.get(position)?.apply {
            holder.itemView.tvProgramName?.text = this.name
        }
    }

    override fun getItemCount(): Int {
        return programsList?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}