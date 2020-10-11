package com.winechitpaing.data.repository.dataSource

import com.winechitpaing.domain.result.LaunchListResult

interface DataSource {
    suspend  fun getLaunchPastList() : LaunchListResult
}