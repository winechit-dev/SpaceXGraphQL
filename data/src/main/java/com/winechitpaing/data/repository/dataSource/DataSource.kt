package com.winechitpaing.data.repository.dataSource

import com.winechitpaing.domain.result.LaunchDetailResult
import com.winechitpaing.domain.result.LaunchsPastResult

interface DataSource {
    suspend  fun getLaunchPastList() : LaunchsPastResult
    suspend fun getLaunchDetail(id : String) : LaunchDetailResult
}