package com.winechitpaing.apollographql.di.app

import android.app.Application
import com.apollographql.apollo.ApolloClient
import com.google.gson.Gson
import com.winechitpaing.data.common.network.ResponseCodeInterceptor
import com.winechitpaing.data.entity.mapper.LaunchPastDataMapper
import com.winechitpaing.data.entity.mapper.LaunchPastJsonMapper
import com.winechitpaing.data.network.SpaceXApi
import com.winechitpaing.data.network.SpaceXApiImpl
import com.winechitpaing.data.platform.NetworkHandler
import com.winechitpaing.data.repository.LaunchListRepository
import com.winechitpaing.data.repository.dataSource.DataSource
import com.winechitpaing.data.repository.dataSource.DataSourceImpl
import com.winechitpaing.domain.repository.DataRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    private var API_BASE_URL = "https://api.spacex.land/graphql/"

    @Provides
    fun application() = application

  /*  @AppScope
    @Apollo
    @Provides
    fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(API_BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }


    @AppScope
    @Provides
    fun okHttpClient() = OkHttpClient.Builder()
        .connectTimeout(90, TimeUnit.SECONDS)
        .readTimeout(90, TimeUnit.SECONDS)
        .writeTimeout(90, TimeUnit.SECONDS)
        .addInterceptor(ResponseCodeInterceptor())
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()*/

    @AppScope
    @Provides
    fun provideSpaceXApi(spaceXApiImpl: SpaceXApiImpl): SpaceXApi = spaceXApiImpl


    @Provides
    fun provideNetworkHandler() = NetworkHandler(application)

    @Provides
    fun provideLaunchPastJsonMapper() = LaunchPastJsonMapper(Gson())

    @Provides
    fun provideLaunchPastDataMapper() = LaunchPastDataMapper()

    @Provides
    fun provideDataRepository(launchListRepository: LaunchListRepository): DataRepository = launchListRepository

    @Provides
    fun provideDataSource(dataSourceImpl: DataSourceImpl): DataSource = dataSourceImpl

}