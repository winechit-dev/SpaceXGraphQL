package com.winechitpaing.domain.model

data class LaunchPast(
    var mission_name: String,
    var launch_date_local: String,
    var launch_site: LaunchSite
)