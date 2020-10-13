package com.winechitpaing.data.network

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.winechitpaing.data.LaunchListQuery
import com.winechitpaing.data.mapper.LaunchPastDataMapper
import com.winechitpaing.data.platform.NetworkHandler
import com.winechitpaing.domain.result.LaunchsPastResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpaceXApiImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val launchPastDataMapper: LaunchPastDataMapper,
    private val apolloClient: ApolloClient
) : SpaceXApi {
    override suspend fun getLaunchPastList(): LaunchsPastResult {
        return withContext(Dispatchers.IO) {
            if (networkHandler.isConnected) {
                val response = try {
                    apolloClient.query(LaunchListQuery()).await()
                } catch (e: ApolloException) {
                    return@withContext LaunchsPastResult.ServerError(e.localizedMessage ?: e.message!!)
                }
                if (response.data != null || response.data?.launchesPast != null) {
                    val dataMapper = launchPastDataMapper.transform(response.data?.launchesPast!!)
                    return@withContext LaunchsPastResult.Success(dataMapper)
                } else {
                    return@withContext LaunchsPastResult.FeatureFailure
                }
            } else {
                return@withContext LaunchsPastResult.NetworkConnection
            }
        }
    }
}