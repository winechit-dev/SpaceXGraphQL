package com.winechitpaing.domain.interactor

import com.winechitpaing.domain.repository.DataRepository

class GetLaunchDetailUseCase(private val repository: DataRepository) {
    suspend operator fun invoke(id : String) = repository.getLaunchDetail(id)
}