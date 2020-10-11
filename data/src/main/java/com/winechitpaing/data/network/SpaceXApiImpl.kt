package com.winechitpaing.data.network

import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import com.winechitpaing.data.LaunchListQuery
import com.winechitpaing.data.entity.mapper.LaunchPastDataMapper
import com.winechitpaing.data.entity.mapper.LaunchPastJsonMapper
import com.winechitpaing.data.platform.NetworkHandler
import com.winechitpaing.domain.result.LaunchListResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpaceXApiImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val launchPastJsonMapper: LaunchPastJsonMapper,
    private val launchPastDataMapper: LaunchPastDataMapper
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
                    val jsonMapper = launchPastJsonMapper.transformLaunchPastEntityList(response.data?.launchesPast!!)
                    val dataMapper = launchPastDataMapper.transform(jsonMapper)
                    return@withContext LaunchListResult.Success(dataMapper)
                } else {
                    return@withContext LaunchListResult.FeatureFailure
                }
            } else {
                return@withContext LaunchListResult.NetworkConnection
            }
        }
    }
}