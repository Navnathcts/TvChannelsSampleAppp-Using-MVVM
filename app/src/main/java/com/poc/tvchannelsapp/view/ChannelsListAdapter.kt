package com.azhar.weatherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poc.tvchannelsapp.R
import com.poc.tvchannelsapp.model.ChannelListModel
import kotlinx.android.synthetic.main.channel_list_item.view.*

class ChannelsListAdapter() : RecyclerView.Adapter<ChannelsListAdapter.ViewHolder>() {

    private var channelList: MutableList<ChannelListModel?>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.channel_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        channelList?.get(position)?.apply {
            holder.itemView.rvProgramList?.apply {
                layoutManager = LinearLayoutManager(
                    holder.itemView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = ProgramsListAdapter(programsList)
            }
            holder.itemView.tvChannelNumber.text = this.accessNum?.toString()
            holder.itemView.tvChannelName.text = this.callSign
        }

    }

    override fun getItemCount(): Int {
        return channelList?.size ?: 0
    }

    fun setChannelList(channelList: MutableList<ChannelListModel?>?) {
        this.channelList = channelList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}