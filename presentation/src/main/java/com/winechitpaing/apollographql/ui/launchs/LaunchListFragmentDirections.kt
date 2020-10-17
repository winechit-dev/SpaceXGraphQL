package com.winechitpaing.apollographql.ui.launchs

import android.os.Bundle
import androidx.navigation.NavDirections
import com.winechitpaing.apollographql.R

class LaunchListFragmentDirections private constructor() {
    private data class OpenLaunchDetails(
        val launchId: String
    ) : NavDirections {
        override fun getActionId(): Int = R.id.action_launch_list_fragment_to_launch_past_detail_fragment

        override fun getArguments(): Bundle {
            val result = Bundle()
            result.putString("launchId", this.launchId)
            return result
        }
    }

    companion object {
        fun openLaunchDetails(launchId: String): NavDirections = OpenLaunchDetails(launchId)
    }
}