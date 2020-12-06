package com.poc.tvchannelsapp.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.poc.swipecarouselapp.data.MainRepository
import com.poc.swipecarouselapp.util.Resource
import com.poc.tvchannelsapp.model.ChannelListModel
import com.poc.tvchannelsapp.model.ProgramListModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private var channelList: MutableList<ChannelListModel?>? = null
    private var mProgramList: MutableList<ProgramListModel?>? = null
    fun getChannelsList() =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                withContext(Dispatchers.IO) {
                    val channel = async { mainRepository.getChannelsList() }
                    val program = async { mainRepository.getProgramsList() }
                    if (channel.await()?.isNotEmpty() == true && program.await()?.isNotEmpty() == true) {
                        channelList = channel.await()
                        mProgramList = program.await()
                        channelList?.forEach { channelItem ->
                            channelItem?.programsList = mProgramList?.filter {
                                it?.recentAirTime?.channelID?.equals(channelItem?.id)==true
                            } as MutableList<ProgramListModel?>?
                        }
                    }
                }
                withContext(Dispatchers.Main) {
                    emit(Resource.success(channelList))
                }
            } catch (e: Exception) {
                emit(Resource.error(data = null, message = "Error Occurred!"))
            }

        }
}