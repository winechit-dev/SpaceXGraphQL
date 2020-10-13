package com.winechitpaing.domain.repository

import com.winechitpaing.domain.result.LaunchsPastResult


interface DataRepository {
    suspend  fun getLaunchPastList() : LaunchsPastResult
}