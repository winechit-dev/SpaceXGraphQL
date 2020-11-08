package com.winechitpaing.apollographql.di.domain

import com.winechitpaing.domain.interactor.GetLaunchDetailUseCase
import com.winechitpaing.domain.interactor.GetLaunchListUseCase
import com.winechitpaing.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    fun provideGetLaunchDetailUseCase(dataRepository: DataRepository) =
        GetLaunchDetailUseCase(dataRepository)

    @Provides
    fun provideGetLaunchListUseCase(dataRepository: DataRepository) =
        GetLaunchListUseCase(dataRepository)
}