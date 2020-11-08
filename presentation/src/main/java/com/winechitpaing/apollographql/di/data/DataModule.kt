package com.winechitpaing.apollographql.di.data

import com.winechitpaing.apollographql.di.app.AppScope
import com.winechitpaing.data.network.SpaceXApi
import com.winechitpaing.data.repository.LaunchListRepository
import com.winechitpaing.data.repository.dataSource.DataSource
import com.winechitpaing.data.repository.dataSource.DataSourceImpl
import com.winechitpaing.domain.repository.DataRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule{

    @Provides
    @AppScope
    fun provideDataRepository(dataSource: DataSource): DataRepository = LaunchListRepository(dataSource)

    @Provides
    @AppScope
    fun provideDataSource(api: SpaceXApi): DataSource = DataSourceImpl(api)

}
