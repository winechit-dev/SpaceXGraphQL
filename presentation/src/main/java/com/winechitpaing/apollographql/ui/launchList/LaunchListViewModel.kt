package com.winechitpaing.apollographql.ui.launchList

import androidx.lifecycle.*
import androidx.navigation.NavController
import com.winechitpaing.domain.interactor.GetLaunchListUseCase
import com.winechitpaing.domain.model.LaunchPast
import com.winechitpaing.domain.result.LaunchListResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class LaunchListViewModel @Inject constructor(
    private val getLaunchListUseCase: GetLaunchListUseCase
) : ViewModel() {

    var navigationController: NavController? = null

    val fetchLaunchList: LiveData<LaunchListResult> = liveData {
        val result: LaunchListResult = getLaunchListUseCase.invoke()
        emit(result)
    }
}