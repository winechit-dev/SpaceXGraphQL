package com.winechitpaing.apollographql.ui.launchList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.common.fragment.BaseFragment
import com.winechitpaing.apollographql.common.viewmodels.ViewModelFactory
import javax.inject.Inject

class LaunchListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: LaunchListViewModel

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

        viewModel = ViewModelProvider(this, viewModelFactory).get(LaunchListViewModel::class.java)

        viewModel.fetchLaunchList()

        viewModel.launchList.observe(viewLifecycleOwner, Observer {
            Log.d("LaunchList", it.toString())
            Toast.makeText(requireContext(), "fetched $it ", Toast.LENGTH_SHORT).show()
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Log.d("LaunchList", it.toString())
            Toast.makeText(requireContext(), "fetched $it ", Toast.LENGTH_SHORT).show()
        })
    }
}