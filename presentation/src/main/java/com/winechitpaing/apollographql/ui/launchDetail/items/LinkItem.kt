package com.winechitpaing.apollographql.ui.launchDetail.items

import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.common.extension.invisible
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.launch_link_recycler_item.view.*

class LinkItem(
    private val title: String,
    private val url: String?,
    private val itemClickListener: OnLinkItemClickListener
) : Item() {

    override fun getLayout(): Int = R.layout.launch_link_recycler_item

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.itemView.text_title.text = title
        if(url != null){
            viewHolder.itemView.setOnClickListener {
                itemClickListener.onLinkItemClicked(url)
            }
        }else{
            viewHolder.itemView.text_title.invisible()
            viewHolder.itemView.invisible()
        }

    }

    interface OnLinkItemClickListener {
        fun onLinkItemClicked(linkUrl: String)
    }
}
