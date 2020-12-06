package com.poc.tvchannelsapp.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.azhar.weatherapp.adapter.ChannelsListAdapter
import com.poc.swipecarouselapp.data.ApiClient
import com.poc.swipecarouselapp.data.ApiHelper
import com.poc.swipecarouselapp.util.Status
import com.poc.swipecarouselapp.util.hideView
import com.poc.swipecarouselapp.util.showView
import com.poc.tvchannelsapp.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var channelListAdapter: ChannelsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        channelListAdapter = ChannelsListAdapter()
        viewModel = ViewModelProviders.of(
            this@MainFragment,
            ViewModelFactory(ApiHelper(ApiClient.apiService))
        ).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvChannelList?.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapter = channelListAdapter
        }
        fetchChannelsWithProgramList()
        btnTryAgain?.setOnClickListener { fetchChannelsWithProgramList() }
    }

    private fun fetchChannelsWithProgramList() {
        channelListShimmerFrame.startShimmerAnimation()
        viewModel.getChannelsList().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    channelListShimmerFrame.stopShimmerAnimation()
                    channelListShimmerFrame.hideView()
                    llErrorView.hideView()
                    rvChannelList.showView()
                    channelListAdapter.setChannelList(it.data)
                }
                Status.ERROR -> {
                    channelListShimmerFrame.stopShimmerAnimation()
                    channelListShimmerFrame.hideView()
                    llErrorView.showView()
                    rvChannelList.hideView()
                }
                Status.LOADING -> {
                    channelListShimmerFrame.showView()
                    llErrorView.hideView()
                    rvChannelList.hideView()
                }
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
