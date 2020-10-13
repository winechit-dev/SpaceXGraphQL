package com.winechitpaing.domain.interactor

import com.winechitpaing.domain.repository.DataRepository
import javax.inject.Inject

class GetLaunchDetailUseCase @Inject constructor(private val repository: DataRepository) {
    suspend operator fun invoke(id : String) = repository.getLaunchDetail(id)
}