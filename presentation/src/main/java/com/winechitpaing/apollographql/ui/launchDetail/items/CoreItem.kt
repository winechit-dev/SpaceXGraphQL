package com.winechitpaing.apollographql.ui.launchDetail.items

import com.winechitpaing.apollographql.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.launch_core_recycler_item.view.*

class CoreItem(
    private val flight: Int?,
    private val block: Int?,
    private val reused: Boolean?,
    private val landSuccess: Boolean?
) : Item() {

    override fun getLayout(): Int = R.layout.launch_core_recycler_item

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val noInfoString = viewHolder.itemView.context.getString(R.string.no_info)

        viewHolder.itemView.text_core_flight.text = flight?.toString() ?: noInfoString
        viewHolder.itemView.text_core_block.text = block?.toString() ?: noInfoString
        viewHolder.itemView.text_core_reused.text = if (reused == true) viewHolder.itemView.context.getString(R.string.yes) else viewHolder.itemView.context.getString(R.string.no)
        viewHolder.itemView.text_land_success.text =  if(landSuccess != null && landSuccess == true) viewHolder.itemView.context.getString(R.string.yes) else  viewHolder.itemView.context.getString(R.string.no)
    }
}
