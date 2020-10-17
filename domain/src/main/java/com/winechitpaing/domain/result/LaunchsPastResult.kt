package com.winechitpaing.domain.result

import com.winechitpaing.domain.model.LaunchPast


sealed class LaunchsPastResult {
    data class Success(val data: List<LaunchPast>) : LaunchsPastResult()
    object NetworkConnection : LaunchsPastResult()
    object FeatureFailure : LaunchsPastResult()
    data class ServerError(val error: String) : LaunchsPastResult()
}