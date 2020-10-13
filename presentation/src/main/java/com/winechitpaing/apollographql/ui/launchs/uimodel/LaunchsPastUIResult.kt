package com.winechitpaing.apollographql.ui.launchs.uimodel


sealed class LaunchsPastUIResult {
    data class Success(val data: List<LaunchsPastUiModel>) : LaunchsPastUIResult()
    object NetworkConnection : LaunchsPastUIResult()
    object FeatureFailure : LaunchsPastUIResult()
    data class ServerError(val error: String) : LaunchsPastUIResult()
}