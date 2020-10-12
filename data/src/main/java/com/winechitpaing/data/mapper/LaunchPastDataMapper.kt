package com.winechitpaing.data.mapper

import com.winechitpaing.data.LaunchListQuery
import com.winechitpaing.domain.model.LaunchPast
import com.winechitpaing.domain.model.Links

class LaunchPastDataMapper {

    private fun transform(entity: LaunchListQuery.LaunchesPast): LaunchPast {
        return LaunchPast(
            id = entity.id ?: "",
            mission_name = entity.mission_name ?: "",
            launch_date_local = (entity.launch_date_local ?: 0L) as String,
            links = Links(
                mission_patch = entity.links?.mission_patch ?: ""
            )
        )
    }

    fun transform(launchPastCollection: List<LaunchListQuery.LaunchesPast?>): List<LaunchPast> {
        return launchPastCollection.map {
            it?.let { launchPast -> transform(launchPast) }!!
        }
    }

}