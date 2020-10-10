package com.winechitpaing.data.repository

import com.winechitpaing.data.repository.dataSource.DataSource
import com.winechitpaing.domain.result.LaunchListResult
import com.winechitpaing.domain.repository.DataRepository
import javax.inject.Inject

class LaunchListRepository @Inject constructor(private val dataSource: DataSource): DataRepository {
    override suspend fun getLaunchPastList(): LaunchListResult {
        return dataSource.getLaunchPastList()
    }
}