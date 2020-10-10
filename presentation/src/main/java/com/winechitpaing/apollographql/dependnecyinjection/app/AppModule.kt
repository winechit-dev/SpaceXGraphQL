package com.winechitpaing.apollographql.dependnecyinjection.app

import android.app.Application
import com.apollographql.apollo.ApolloClient
import com.winechitpaing.data.common.network.ResponseCodeInterceptor
import com.winechitpaing.data.network.SpaceXApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
class AppModule(val application: Application) {


    @Provides
    @AppScope
    @Apollo
    fun apolloClient (okHttpClient :  OkHttpClient): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(SpaceXApi.API_BASE_URL)
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
        .build()

}