package com.winechitpaing.apollographql.ui.launchList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.adapter.LaunchesAdapter
import com.winechitpaing.apollographql.common.fragment.BaseFragment
import com.winechitpaing.apollographql.common.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_launch_list.*
import javax.inject.Inject

class LaunchListFragment : BaseFragment(), LaunchesAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var viewModel : LaunchListViewModel


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

        rv_launch_past.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = launchesAdapter
        }

        viewModel.fetchLaunchList()

        viewModel.launchList.observe(viewLifecycleOwner, Observer {
            launchesAdapter.setData(it)
            Log.d("LaunchList", it.toString())
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Log.d("LaunchList", it.toString())
            Toast.makeText(requireContext(), "fetched $it ", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onItemClicked(launchIndex: Int, itemView: View) {

    }
}