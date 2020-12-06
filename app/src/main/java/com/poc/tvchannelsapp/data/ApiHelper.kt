package com.poc.swipecarouselapp.data


class ApiHelper(private val apiService: APIInterface?) {

    suspend fun getChannelsList() =
        apiService?.getChannelsList()

    suspend fun getProgramsList() =
        apiService?.getProgramsList()
}