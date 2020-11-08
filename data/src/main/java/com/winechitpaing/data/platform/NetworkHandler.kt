package com.winechitpaing.data.platform

import android.content.Context
import com.winechitpaing.data.common.extension.networkInfo

/**
 * Injectable class which returns information about the network connection state.
 */
class NetworkHandler constructor(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnectedOrConnecting ?: false
}