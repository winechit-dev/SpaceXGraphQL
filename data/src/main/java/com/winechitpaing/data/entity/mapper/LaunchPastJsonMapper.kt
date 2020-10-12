package com.winechitpaing.data.entity.mapper

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.winechitpaing.data.LaunchListQuery
import com.winechitpaing.data.entity.LaunchPastEntity
import com.winechitpaing.data.entity.LinkEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchPastJsonMapper @Inject constructor(private val gson: Gson) {

    @Throws(JsonSyntaxException::class)
    fun transformLaunchPastEntity(userJsonResponse: String?): LaunchPastEntity? {
        val entityType = object : TypeToken<LaunchPastEntity?>() {}.type
        return gson.fromJson(userJsonResponse, entityType)
    }

    @Throws(JsonSyntaxException::class)
    fun transformLaunchPastEntityList(responseObject: List<LaunchListQuery.LaunchesPast?>): List<LaunchPastEntity?> {
        val list: MutableList<LaunchPastEntity> = mutableListOf()

        responseObject.forEach {
            list.add(
                LaunchPastEntity(
                    id = it?.id ?: "",
                    mission_name = it?.mission_name ?: "",
                    launch_date_local = ((it?.launch_date_local ?: 0) as String),
                    links = LinkEntity((it?.links?.mission_patch.toString()) )
                )
            )
        }
        return list
    }
}