package com.winechitpaing.apollographql.ui.launchList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.adapter.LaunchesAdapter
import com.winechitpaing.apollographql.common.extension.toast
import com.winechitpaing.apollographql.common.fragment.BaseFragment
import com.winechitpaing.apollographql.common.viewmodels.ViewModelFactory
import com.winechitpaing.domain.result.LaunchListResult
import kotlinx.android.synthetic.main.fragment_launch_list.*
import javax.inject.Inject

class LaunchListFragment : BaseFragment(), LaunchesAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var viewModel: LaunchListViewModel

    private val launchesAdapter: LaunchesAdapter by lazy {
        LaunchesAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
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
        rv_launch_past.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = launchesAdapter
        }

        viewModel.fetchLaunchList.observe(viewLifecycleOwner, { result ->
            when (result) {
                is LaunchListResult.Success -> launchesAdapter.setData(result.data)
                is LaunchListResult.FeatureFailure -> requireContext().toast(result.toString())
                is LaunchListResult.NetworkConnection -> requireContext().toast(getString(R.string.msg_no_internet_connection))
                is LaunchListResult.ServerError -> requireContext().toast(getString(R.string.msg_sever_error))
                else -> requireContext().toast(getString(R.string.msg_unknow_error))
            }
        })
    }

    override fun onItemClicked(launchIndex: Int, itemView: View) {

    }
}