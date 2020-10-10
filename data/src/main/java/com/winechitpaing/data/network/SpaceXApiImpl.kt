package com.winechitpaing.data.network

import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import com.winechitpaing.data.LaunchListQuery
import com.winechitpaing.data.platform.NetworkHandler
import com.winechitpaing.domain.result.LaunchListResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpaceXApiImpl @Inject constructor(
    private val networkHandler: NetworkHandler
) : SpaceXApi {
    override suspend fun getLaunchPastList(): LaunchListResult {
        return withContext(Dispatchers.IO) {
            if (networkHandler.isConnected) {
                val response = try {
                    apolloClient().query(LaunchListQuery()).toDeferred().await()
                } catch (e: ApolloException) {
                    return@withContext LaunchListResult.ServerError(e.localizedMessage ?: e.message!!)
                }
                if (response.data != null || response.data?.launchesPast != null) {
                    return@withContext LaunchListResult.Success(listOf(response.data?.launchesPast!!))
                } else {
                    return@withContext LaunchListResult.FeatureFailure
                }
            } else {
                return@withContext LaunchListResult.NetworkConnection
            }
        }
    }
}