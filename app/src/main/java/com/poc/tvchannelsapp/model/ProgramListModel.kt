package com.poc.tvchannelsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProgramListModel: Serializable {
    @SerializedName("startTime")
    @Expose
    var startTime: String? = null

    @SerializedName("recentAirTime")
    @Expose
    var recentAirTime: RecentAirTime? = null

    @SerializedName("length")
    @Expose
    var length: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null
}