package com.winechitpaing.domain.model

data class LaunchDetail(
    var id: String,
    var mission_name: String,
    var launch_date_local: String,
    var launch_site: LaunchSite?,
    var links: Links?,
    var rocket: Rocket?
)