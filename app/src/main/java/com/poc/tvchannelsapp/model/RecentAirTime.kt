package com.poc.tvchannelsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RecentAirTime:Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("channelID")
    @Expose
    var channelID: Int? = null
}