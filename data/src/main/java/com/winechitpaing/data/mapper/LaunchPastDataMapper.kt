package com.winechitpaing.data.mapper

import com.winechitpaing.data.LaunchDetailQuery
import com.winechitpaing.data.LaunchListQuery
import com.winechitpaing.domain.model.*

class LaunchPastDataMapper {

    private fun transform(launchesPast: LaunchListQuery.LaunchesPast): LaunchPast {
        return LaunchPast(
            id = launchesPast.id ?: "",
            mission_name = launchesPast.mission_name ?: "",
            launch_date_local = launchesPast.launch_date_local.toString(),
            mission_patch = launchesPast.links?.mission_patch ?: ""
        )
    }

    fun transform(launchPastCollection: List<LaunchListQuery.LaunchesPast?>): List<LaunchPast> {
        return launchPastCollection.map {
            it?.let { launchPast -> transform(launchPast) }!!
        }
    }


    fun transform(data: LaunchDetailQuery.Launch): LaunchDetail {
        return LaunchDetail(
            id = data.id ?: "",
            mission_name = data.mission_name ?: "",
            launch_date_local = data.launch_date_local.toString(),
            launch_site = if (data.launch_site != null) transform(data.launch_site) else null,
            links = if (data.links != null) transform(data.links) else null,
            rocket = if (data.rocket != null) transform(data.rocket) else null
        )
    }


    private fun transform(launchSite: LaunchDetailQuery.Launch_site): LaunchSite {
        return LaunchSite(
            site_name = launchSite.site_name,
            site_name_long = launchSite.site_name_long
        )
    }

    private fun transform(links: LaunchDetailQuery.Links): Links {
        return Links(
            article_link = links.article_link,
            video_link = links.video_link,
            wikipedia = links.wikipedia,
            mission_patch = links.mission_patch
        )
    }

    private fun transform(rocket: LaunchDetailQuery.Rocket): Rocket {
        return Rocket(
            rocket_name = rocket.rocket_name,
            cores = transform(rocket.first_stage?.cores),
            block = rocket.second_stage?.block,
            payloads = transform(rocket.second_stage?.payloads)
        )
    }


    @JvmName("transformCore")
    private fun transform(cores: List<LaunchDetailQuery.Core?>?): List<Cores> {
        return cores?.let { it ->
            it.map {
                Cores(
                    flight = it?.flight,
                    block = it?.block,
                    land_success = it?.land_success,
                    landing_type = it?.landing_type,
                    landing_vehicle = it?.landing_vehicle,
                    reused = it?.reused
                )
            }
        } ?: emptyList()
    }


    @JvmName("transformPayload")
    private fun transform(payloads: List<LaunchDetailQuery.Payload?>?): List<Payload> {
        return payloads?.map {
            Payload(
                id = it?.id,
                payload_type = it?.payload_type,
                payload_mass_kg = it?.payload_mass_kg,
                payload_mass_lbs = it?.payload_mass_lbs,
                reused = it?.reused,
                customers = it?.customers,
                nationality = it?.nationality,
                orbit = it?.orbit,
                manufacturer = it?.manufacturer
            )
        } ?: emptyList()
    }
}