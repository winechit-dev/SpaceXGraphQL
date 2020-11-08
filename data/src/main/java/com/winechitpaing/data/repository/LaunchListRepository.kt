package com.winechitpaing.data.repository

import com.winechitpaing.data.repository.dataSource.DataSource
import com.winechitpaing.domain.result.LaunchsPastResult
import com.winechitpaing.domain.repository.DataRepository
import com.winechitpaing.domain.result.LaunchDetailResult

class LaunchListRepository (private val dataSource: DataSource): DataRepository {
    override suspend fun getLaunchPastList(): LaunchsPastResult {
        return dataSource.getLaunchPastList()
    }

    override suspend fun getLaunchDetail(id: String): LaunchDetailResult {
        return dataSource.getLaunchDetail(id)
    }
}