package com.winechitpaing.data.repository.dataSource

import com.winechitpaing.data.network.SpaceXApi
import com.winechitpaing.domain.result.LaunchListResult
import javax.inject.Inject

class DataSourceImpl @Inject constructor(private val api: SpaceXApi) : DataSource {
    override suspend fun getLaunchPastList(): LaunchListResult {
        return api.getLaunchPastList()
    }
}