package com.winechitpaing.domain.result

import com.winechitpaing.domain.model.LaunchPast


sealed class LaunchListResult {
    data class Success(val data: List<LaunchPast>) : LaunchListResult()
    object NetworkConnection : LaunchListResult()
    object FeatureFailure : LaunchListResult()
    data class ServerError(val error: String) : LaunchListResult()
}