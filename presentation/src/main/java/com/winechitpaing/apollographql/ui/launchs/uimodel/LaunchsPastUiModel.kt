package com.winechitpaing.apollographql.ui.launchs.uimodel

import com.winechitpaing.domain.model.Links

data class LaunchsPastUiModel(
    var id: String,
    var mission_name: String,
    var launch_date_local: String,
    var links: Links
)