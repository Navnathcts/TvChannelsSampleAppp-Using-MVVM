package com.poc.swipecarouselapp.data

import com.poc.tvchannelsapp.model.ChannelListModel
import com.poc.tvchannelsapp.model.ProgramListModel
import retrofit2.http.GET
import retrofit2.http.Query


interface APIInterface {

    @GET("Channels")
    suspend fun getChannelsList() : MutableList<ChannelListModel?>?

    @GET("ProgramItems")
    suspend fun getProgramsList(): MutableList<ProgramListModel?>?
}