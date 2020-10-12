package com.winechitpaing.data.entity.mapper

import com.winechitpaing.data.entity.LaunchPastEntity
import com.winechitpaing.data.entity.LaunchSiteEntity
import com.winechitpaing.data.entity.LinkEntity
import com.winechitpaing.domain.model.LaunchPast
import com.winechitpaing.domain.model.LaunchSite
import com.winechitpaing.domain.model.Links
import java.util.*

class LaunchPastDataMapper {

    private fun transform(entity: LaunchPastEntity): LaunchPast {
        return LaunchPast(
            id = entity.id,
            mission_name = entity.mission_name,
            launch_date_local = entity.launch_date_local,
            links = transform(entity.links)
        )
    }

    private fun transform(entity: LinkEntity): Links {
        return Links(
            mission_patch = entity.mission_patch
        )
    }

    fun transform(launchPastCollection: List<LaunchPastEntity?>): List<LaunchPast> {
        val launchPast: MutableList<LaunchPast> = ArrayList<LaunchPast>(20)

        launchPastCollection.forEach {
            if (it != null) launchPast.add(transform(it))
        }

        return launchPast
    }
}