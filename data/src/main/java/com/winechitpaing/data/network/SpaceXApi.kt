package com.winechitpaing.data.network

import com.winechitpaing.domain.result.LaunchListResult

interface SpaceXApi {
    companion object {
        var API_BASE_URL = "https://api.spacex.land/graphql/"
    }

   suspend  fun getLaunchPastList() : LaunchListResult
}