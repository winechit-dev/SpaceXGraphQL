package com.winechitpaing.domain.repository

import com.winechitpaing.domain.result.LaunchDetailResult
import com.winechitpaing.domain.result.LaunchsPastResult


interface DataRepository {
    suspend  fun getLaunchPastList() : LaunchsPastResult
    suspend fun getLaunchDetail(id : String) : LaunchDetailResult
}