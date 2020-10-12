package com.winechitpaing.apollographql.ui.launchList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private var _launchList = MutableLiveData<List<LaunchPast>>()
    val launchList: LiveData<List<LaunchPast>>
        get() = _launchList

    private var _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage


     fun fetchLaunchList() {
        viewModelScope.launch {

            when (val result: LaunchListResult = getLaunchListUseCase.invoke()) {
                is LaunchListResult.Success -> result.let {
                    _launchList.value = it.data
                }
                is LaunchListResult.FeatureFailure -> result.let {
                    _errorMessage.value = it.toString()
                }
                is LaunchListResult.NetworkConnection -> _errorMessage.value =
                    "No internet connection"
                is LaunchListResult.ServerError -> _errorMessage.value = "Sever Error"
                else -> _errorMessage.value = "Unknown Error"
            }
        }
    }
}