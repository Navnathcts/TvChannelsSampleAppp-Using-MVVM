package com.poc.tvchannelsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ChannelListModel :Serializable{
    @SerializedName("orderNum")
    @Expose
    var orderNum: Int? = null

    @SerializedName("accessNum")
    @Expose
    var accessNum: Int? = null

    @SerializedName("CallSign")
    @Expose
    var callSign: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("programsList")
    @Expose
    var programsList: MutableList<ProgramListModel?>? = mutableListOf()
}