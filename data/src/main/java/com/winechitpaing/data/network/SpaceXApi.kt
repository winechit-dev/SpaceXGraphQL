package com.winechitpaing.data.network

import com.winechitpaing.domain.result.LaunchDetailResult
import com.winechitpaing.domain.result.LaunchsPastResult

interface SpaceXApi {

   suspend  fun getLaunchPastList() : LaunchsPastResult

    suspend fun getLaunchDetail(id : String) : LaunchDetailResult
}