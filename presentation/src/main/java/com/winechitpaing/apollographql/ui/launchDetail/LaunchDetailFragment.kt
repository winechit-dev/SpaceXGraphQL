package com.winechitpaing.apollographql.ui.launchDetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.common.extension.invisible
import com.winechitpaing.apollographql.common.extension.visible
import com.winechitpaing.apollographql.common.fragment.BaseFragment
import com.winechitpaing.apollographql.common.viewmodels.ViewModelFactory
import com.winechitpaing.apollographql.ui.launchDetail.items.*
import com.winechitpaing.apollographql.ui.launchs.LaunchsViewModel
import com.winechitpaing.data.common.extension.toast
import com.winechitpaing.domain.model.LaunchDetail
import com.winechitpaing.domain.result.LaunchDetailResult
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_launch_past_detail.*
import javax.inject.Inject


class LaunchDetailFragment : BaseFragment(), LinkItem.OnLinkItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var viewModel: LaunchsViewModel

    private val args: LaunchDetailFragmentArgs by navArgs()

    private  val groupAdapter: GroupAdapter<GroupieViewHolder> by lazy { GroupAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launch_past_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        recyclerView.invisible()
        progress_bar.visible()

        recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = groupAdapter
        }

        viewModel.getLaunchDetail(args.launchId).observe(viewLifecycleOwner, { result ->
            when (result) {
                is LaunchDetailResult.Success -> bindData(result.data)
                is LaunchDetailResult.FeatureFailure -> requireContext().toast(getString(R.string.msg_data_not_found))
                is LaunchDetailResult.NetworkConnection -> requireContext().toast(getString(R.string.msg_no_internet_connection))
                is LaunchDetailResult.ServerError -> requireContext().toast(result.toString())
                else -> requireContext().toast(getString(R.string.msg_unknow_error))
            }
        })
    }

    private fun bindData(launch : LaunchDetail) {
        Log.d("LaunchDetail", launch.toString())

        // Implement diff utils in future
        groupAdapter.clear()

        // Card with main info about launch
        groupAdapter.add(
            LaunchDetailHeaderItem(
                launch.rocket!!.cores[0].flight,
                launch.links?.mission_patch,
                launch.mission_name,
                launch.launch_date_local,
                launch.launch_site?.site_name
            )
        )

        //cores
        val coresHeaderItem = ExpandableHeaderItem(getString(R.string.label_cores))
        val coresGroup = ExpandableGroup(coresHeaderItem)
        launch.rocket?.cores?.forEach { core ->
            coresGroup.add(
                CoreItem(
                    core.flight,
                    core.block,
                    core.reused,
                    core.land_success
                )
            )
        }
        groupAdapter.add(coresGroup)


        //payload
        val payloadsHeaderItem = ExpandableHeaderItem(getString(R.string.payloads))
        val payloadsGroup = ExpandableGroup(payloadsHeaderItem)
        launch.rocket?.payloads?.forEach { payload ->
            payloadsGroup.add(
                PayloadItem(
                    payload.id,
                    payload.nationality,
                    payload.manufacturer,
                    payload.payload_type,
                    payload.payload_mass_kg,
                    payload.orbit,
                    payload.reused,
                    payload.customers?.get(0)
                )
            )
        }
        groupAdapter.add(payloadsGroup)

        // Section with links
        val linksHeaderItem = ExpandableHeaderItem(getString(R.string.links))
        val linksGroup = ExpandableGroup(linksHeaderItem)

        linksGroup.add(
            LinkItem(
                 "Article",
                launch.links?.article_link,
                this
            )
        )

        linksGroup.add(
            LinkItem(
                "Video",
                launch.links?.video_link,
                this
            )
        )

        linksGroup.add(
            LinkItem(
                "Wikipedia",
                launch.links?.wikipedia,
                this
            )
        )
        groupAdapter.add(linksGroup)

        recyclerView.visible()
        progress_bar.invisible()
    }


    override fun onLinkItemClicked(linkUrl: String) {
        openWebUrl(linkUrl)
    }

    private fun openWebUrl(linkUrl: String) {
        if (linkUrl.isNotEmpty()) startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(linkUrl)
            )
        )
    }


}