package com.winechitpaing.data.network

import android.content.Context
import android.os.Looper
import com.apollographql.apollo.ApolloClient
import com.winechitpaing.data.common.network.ResponseCodeInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

fun apolloClient (): ApolloClient {
    check(Looper.myLooper() == Looper.getMainLooper()) {
        "Only the main thread can get the apolloClient instance"
    }

    val okHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .addInterceptor(ResponseCodeInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    val instance: ApolloClient by lazy {
        ApolloClient.builder()
            .serverUrl(SpaceXApi.API_BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }

    return instance
}
