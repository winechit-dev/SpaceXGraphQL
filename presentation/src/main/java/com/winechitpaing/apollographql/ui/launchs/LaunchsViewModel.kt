package com.winechitpaing.apollographql.ui.launchs

import androidx.lifecycle.*
import androidx.navigation.NavController
import com.winechitpaing.apollographql.ui.launchs.uimodel.LaunchsPastUIResult
import com.winechitpaing.apollographql.ui.launchs.uimodel.LaunchsPastUiModel
import com.winechitpaing.apollographql.utils.getLocalTimeFromUnix
import com.winechitpaing.domain.interactor.GetLaunchDetailUseCase
import com.winechitpaing.domain.interactor.GetLaunchListUseCase
import com.winechitpaing.domain.model.LaunchPast
import com.winechitpaing.domain.result.LaunchDetailResult
import com.winechitpaing.domain.result.LaunchsPastResult
import javax.inject.Inject

class LaunchsViewModel @Inject constructor(
    private val getLaunchListUseCase: GetLaunchListUseCase,
    private val getLaunchDetailUseCase: GetLaunchDetailUseCase
) : ViewModel() {

    val fetchLaunchList: LiveData<LaunchsPastUIResult> = liveData {
        when (val result: LaunchsPastResult = getLaunchListUseCase.invoke()) {
            is LaunchsPastResult.Success -> emit(LaunchsPastUIResult.Success(transform(result.data)))
            is LaunchsPastResult.FeatureFailure -> emit(LaunchsPastUIResult.FeatureFailure)
            is LaunchsPastResult.NetworkConnection -> emit(LaunchsPastUIResult.NetworkConnection)
            is LaunchsPastResult.ServerError -> emit(LaunchsPastUIResult.ServerError(result.error))
        }
    }

    private fun transform(launchPastCollection: List<LaunchPast>): List<LaunchsPastUiModel> {
        return launchPastCollection.map {
            LaunchsPastUiModel(
                it.id,
                it.mission_name,
                getLocalTimeFromUnix(it.launch_date_local),
                it.mission_patch
            )
        }
    }

    fun getLaunchDetail(id: String): LiveData<LaunchDetailResult> = liveData {
        val result: LaunchDetailResult = getLaunchDetailUseCase.invoke(id)
        emit(result)
    }

}