package com.winechitpaing.data.network

import com.winechitpaing.domain.result.LaunchsPastResult

interface SpaceXApi {
    companion object {
        var API_BASE_URL = "https://api.spacex.land/graphql/"
    }

   suspend  fun getLaunchPastList() : LaunchsPastResult
}