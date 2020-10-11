package com.winechitpaing.domain.interactor

import com.winechitpaing.domain.repository.DataRepository
import javax.inject.Inject

class GetLaunchListUseCase @Inject constructor(private val repository: DataRepository) {
    suspend operator fun invoke() = repository.getLaunchPastList()
}