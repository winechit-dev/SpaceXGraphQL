package com.winechitpaing.apollographql.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.common.extension.inflate
import com.winechitpaing.apollographql.common.extension.loadFromUrl
import com.winechitpaing.apollographql.ui.launchs.uimodel.LaunchsPastUiModel
import kotlinx.android.synthetic.main.launches_recycler_item.view.*

class LaunchesAdapter(
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<LaunchesAdapter.ViewHolder>() {

    private var launchesList: List<LaunchsPastUiModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        parent.inflate(R.layout.launches_recycler_item)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (launchesList.isNotEmpty()) holder.bind(launchesList[position], itemClickListener)
    }

    override fun getItemCount(): Int = launchesList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(launch: LaunchsPastUiModel, itemClickListener: OnItemClickListener) {

            itemView.text_launch_date.text = launch.launch_date_local
            itemView.text_mission_name.text = launch.mission_name

            if (!launch.mission_patch.isBlank()) {
               itemView.image_mission_patch.loadFromUrl(launch.mission_patch)
            }

            itemView.setOnClickListener {
                itemClickListener.onItemClicked(launch.id)
            }
        }
    }

    fun setData(list: List<LaunchsPastUiModel>) {
        launchesList = list
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClicked(id : String)
    }
}
