package com.winechitpaing.data.entity

import com.google.gson.annotations.SerializedName

data class LaunchPastEntity(
    @SerializedName("id") val id: String,
    @SerializedName("mission_name") val mission_name: String,
    @SerializedName("launch_date_local") val launch_date_local: String,
    @SerializedName("links") val links: LinkEntity
)