package com.winechitpaing.domain.interactor

import com.winechitpaing.domain.repository.DataRepository

class GetLaunchListUseCase(private val repository: DataRepository) {
    suspend operator fun invoke() = repository.getLaunchPastList()
}