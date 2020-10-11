package com.winechitpaing.domain.repository

import com.winechitpaing.domain.result.LaunchListResult


interface DataRepository {
    suspend  fun getLaunchPastList() : LaunchListResult
}