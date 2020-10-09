package com.winechitpaing.apollographql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.winechitpaing.data.network.SpaceXApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apolloClient = ApolloClient.builder()
            .serverUrl(SpaceXApi.API_BASE_URL)
            .build()

        lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(LaunchListQuery()).toDeferred().await()

            Log.d("LaunchList", "Success ${response.data}")
        }
    }
}