package com.winechitpaing.apollographql.ui.launchs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.adapter.LaunchesAdapter
import com.winechitpaing.apollographql.common.extension.invisible
import com.winechitpaing.apollographql.common.extension.visible
import com.winechitpaing.apollographql.common.fragment.BaseFragment
import com.winechitpaing.apollographql.ui.launchs.uimodel.LaunchsPastUIResult
import com.winechitpaing.data.common.extension.toast
import kotlinx.android.synthetic.main.fragment_launch_list.*

class LaunchsFragment : BaseFragment(), LaunchesAdapter.OnItemClickListener {

    private val viewModel by viewModels<LaunchsViewModel>{viewModelFactory}

    private val launchesAdapter: LaunchesAdapter by lazy {
        LaunchesAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launch_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        progress_bar.visible()
        rv_launch_past.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = launchesAdapter
        }

        viewModel.fetchLaunchList.observe(viewLifecycleOwner, { result ->
            progress_bar.invisible()
            when (result) {
                is LaunchsPastUIResult.Success -> launchesAdapter.setData(result.data)
                is LaunchsPastUIResult.FeatureFailure -> requireContext().toast(getString(R.string.msg_data_not_found))
                is LaunchsPastUIResult.NetworkConnection -> requireContext().toast(getString(R.string.msg_no_internet_connection))
                is LaunchsPastUIResult.ServerError -> requireContext().toast(result.toString())
                else -> requireContext().toast(getString(R.string.msg_unknow_error))
            }
        })
    }

    override fun onItemClicked(id: String) {
        findNavController().navigate(
            LaunchListFragmentDirections.openLaunchDetails(launchId = id)
        )
    }
}