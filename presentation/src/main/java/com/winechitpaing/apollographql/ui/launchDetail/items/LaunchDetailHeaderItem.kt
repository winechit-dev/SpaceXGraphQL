package com.winechitpaing.apollographql.ui.launchDetail.items

import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.common.extension.invisible
import com.winechitpaing.apollographql.common.extension.loadFromUrl
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.recycler_header_item.view.*

open class LaunchDetailHeaderItem(
    private val flightNumber: Int?,
    private val missionPatchSmall: String?,
    private val missionName: String,
    private val launchDateUnix: String?,
    private val siteName: String?
) : Item() {

    override fun getLayout(): Int = R.layout.recycler_header_item

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.itemView.image_mission_patch.loadFromUrl(missionPatchSmall)

        if (flightNumber != null) {
            viewHolder.itemView.text_flight_number.text = flightNumber.toString()
        } else {
            viewHolder.itemView.lbl_text_flight_number.invisible()
            viewHolder.itemView.text_flight_number.invisible()
        }

        viewHolder.itemView.text_mission_name.text = missionName
        viewHolder.itemView.text_launch_date.text = launchDateUnix

        if (siteName != null) {
            viewHolder.itemView.text_launch_site_name.text = siteName
        } else {
            viewHolder.itemView. text_launch_site_name.invisible()
            viewHolder.itemView.lbl_text_launch_site_name.invisible()
        }
    }
}
