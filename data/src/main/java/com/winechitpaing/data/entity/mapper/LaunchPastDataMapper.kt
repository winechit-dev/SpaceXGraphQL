package com.winechitpaing.data.entity.mapper

import com.winechitpaing.data.entity.LaunchPastEntity
import com.winechitpaing.data.entity.LaunchSiteEntity
import com.winechitpaing.domain.model.LaunchPast
import com.winechitpaing.domain.model.LaunchSite
import java.util.*

class LaunchPastDataMapper {

    private fun transform(entity: LaunchPastEntity): LaunchPast {
        return LaunchPast(
            mission_name = entity.mission_name,
            launch_date_local = entity.launch_date_local,
            launch_site = transform(entity.launch_siteEntity)
        )
    }

    private fun transform(entity: LaunchSiteEntity): LaunchSite {
        return LaunchSite(
            site_name_long = entity.site_name_long
        )
    }

    fun transform(launchPastCollection: List<LaunchPastEntity?>): List<LaunchPast> {
        val launchPast: MutableList<LaunchPast> = ArrayList<LaunchPast>(20)

        launchPastCollection.forEach {
            if(it != null) launchPast.add(transform(it))
        }

        return launchPast
    }
}