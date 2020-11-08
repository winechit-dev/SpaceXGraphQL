package com.winechitpaing.apollographql.di.app

import android.app.Application
import com.apollographql.apollo.ApolloClient
import com.winechitpaing.apollographql.di.data.DataModule
import com.winechitpaing.apollographql.di.domain.DomainModule
import com.winechitpaing.data.common.network.ResponseCodeInterceptor
import com.winechitpaing.data.mapper.LaunchPastDataMapper
import com.winechitpaing.data.network.SpaceXApi
import com.winechitpaing.data.network.SpaceXApiImpl
import com.winechitpaing.data.platform.NetworkHandler
import com.winechitpaing.data.repository.LaunchListRepository
import com.winechitpaing.data.repository.dataSource.DataSource
import com.winechitpaing.data.repository.dataSource.DataSourceImpl
import com.winechitpaing.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module(includes = [DataModule::class, DomainModule::class])
class AppModule(private val application: Application) {

    private var API_BASE_URL = "https://api.spacex.land/graphql/"

    @Provides
    fun application() = application

    @AppScope
    @Provides
    fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(API_BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }

    @AppScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(90, TimeUnit.SECONDS)
        .readTimeout(90, TimeUnit.SECONDS)
        .writeTimeout(90, TimeUnit.SECONDS)
        .addInterceptor(ResponseCodeInterceptor())
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @AppScope
    @Provides
    fun provideSpaceXApi(
        networkHandler: NetworkHandler,
        launchPastDataMapper: LaunchPastDataMapper,
        apolloClient: ApolloClient
    ): SpaceXApi = SpaceXApiImpl(
        networkHandler = networkHandler,
        launchPastDataMapper = launchPastDataMapper,
        apolloClient = apolloClient
    )


    @Provides
    fun provideNetworkHandler() = NetworkHandler(application)

    @Provides
    fun provideLaunchPastDataMapper() = LaunchPastDataMapper()

}