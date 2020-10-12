package com.winechitpaing.apollographql.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.common.extension.inflate
import com.winechitpaing.apollographql.common.extension.loadFromUrl
import com.winechitpaing.apollographql.utils.getLocalTimeFromUnix
import com.winechitpaing.domain.model.LaunchPast
import kotlinx.android.synthetic.main.launches_recycler_item.view.*

class LaunchesAdapter(
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<LaunchesAdapter.ViewHolder>() {

    private var launchesList: List<LaunchPast> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        parent.inflate(R.layout.launches_recycler_item)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (launchesList.isNotEmpty()) holder.bind(launchesList[position], itemClickListener)
    }

    override fun getItemCount(): Int = launchesList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(launch: LaunchPast, itemClickListener: OnItemClickListener) {
            // set transition name for shared element container transition
            //itemView.transitionName = launchesList.indexOf(launch).toString()

            itemView.text_launch_date.text = getLocalTimeFromUnix(launch.launch_date_local.toLongOrNull() ?: 0L)
            itemView.text_mission_name.text = launch.mission_name


            if (!launch.links.mission_patch.isBlank()) {
               itemView.image_mission_patch.loadFromUrl(launch.links.mission_patch)
            }

            itemView.setOnClickListener {
                if (adapterPosition != -1) itemClickListener.onItemClicked(
                    launchesList.indexOf(launch),
                    itemView
                )
            }
        }
    }

    fun setData(data: List<LaunchPast>) {
        launchesList = data
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClicked(launchIndex: Int, itemView: View)
    }
}
