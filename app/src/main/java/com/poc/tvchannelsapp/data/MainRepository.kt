package com.poc.swipecarouselapp.data



class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getChannelsList( ) = apiHelper.getChannelsList()
    suspend fun getProgramsList() = apiHelper.getProgramsList()

}