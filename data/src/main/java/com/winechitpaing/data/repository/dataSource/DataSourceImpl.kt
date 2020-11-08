package com.winechitpaing.data.repository.dataSource

import com.winechitpaing.data.network.SpaceXApi
import com.winechitpaing.domain.result.LaunchDetailResult
import com.winechitpaing.domain.result.LaunchsPastResult

class DataSourceImpl(private val api: SpaceXApi) : DataSource {
    override suspend fun getLaunchPastList(): LaunchsPastResult {
        return api.getLaunchPastList()
    }

    override suspend fun getLaunchDetail(id: String): LaunchDetailResult {
        return api.getLaunchDetail(id)
    }
}