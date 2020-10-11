package com.winechitpaing.apollographql.launchList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winechitpaing.data.LaunchListQuery
import com.winechitpaing.domain.interactor.GetLaunchListUseCase
import com.winechitpaing.domain.result.LaunchListResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class LaunchListViewModel @Inject constructor(
    private val getLaunchListUseCase: GetLaunchListUseCase
) : ViewModel() {

    private lateinit var _launchList: MutableLiveData<LaunchListQuery.LaunchesPast>
    val launchList: LiveData<LaunchListQuery.LaunchesPast>
        get() = _launchList

    private lateinit var _errorMessage: MutableLiveData<String>
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun fetchLaunchList() {
        viewModelScope.launch {

            when (val result: LaunchListResult = getLaunchListUseCase.invoke()) {
                is LaunchListResult.Success -> result.let {
                    _launchList.value = it.data as LaunchListQuery.LaunchesPast
                }
                is LaunchListResult.FeatureFailure -> result.let {
                    _errorMessage.value =   it.toString()
                }
                is LaunchListResult.NetworkConnection -> _errorMessage.value = "No internet connection"
                is LaunchListResult.ServerError -> _errorMessage.value = "Sever Error"
                else -> _errorMessage.value = "Unknown Error"
            }
        }
    }
}