package com.winechitpaing.domain.result

import com.winechitpaing.domain.model.LaunchDetail


sealed class LaunchDetailResult {
    data class Success(val data: LaunchDetail) : LaunchDetailResult()
    object NetworkConnection : LaunchDetailResult()
    object FeatureFailure : LaunchDetailResult()
    data class ServerError(val error: String) : LaunchDetailResult()
}