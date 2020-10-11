package com.winechitpaing.domain.result


sealed class LaunchListResult {
    data class Success(val data: List<Any>) : LaunchListResult()
    object NetworkConnection : LaunchListResult()
    object  FeatureFailure : LaunchListResult()
    data class ServerError(val error: String) : LaunchListResult()
}