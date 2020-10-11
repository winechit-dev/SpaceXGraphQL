package com.winechitpaing.apollographql.di.presentation.modules

import androidx.savedstate.SavedStateRegistryOwner
import com.winechitpaing.data.entity.mapper.LaunchPastDataMapper
import com.winechitpaing.data.entity.mapper.LaunchPastJsonMapper
import com.winechitpaing.data.platform.NetworkHandler
import com.winechitpaing.data.repository.dataSource.DataSource
import com.winechitpaing.data.repository.dataSource.DataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val savedStateRegistryOwner: SavedStateRegistryOwner) {

    @Provides
    fun savedStateRegistryOwner() = savedStateRegistryOwner

}