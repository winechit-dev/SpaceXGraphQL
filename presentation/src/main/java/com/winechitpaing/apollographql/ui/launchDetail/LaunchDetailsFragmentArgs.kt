package com.winechitpaing.apollographql.ui.launchDetail

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException

data class LaunchDetailsFragmentArgs(
    val launchId: String
) : NavArgs {
    fun toBundle(): Bundle {
        val result = Bundle()
        result.putString("launchId", this.launchId)
        return result
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle): LaunchDetailsFragmentArgs {
            bundle.setClassLoader(LaunchDetailsFragmentArgs::class.java.classLoader)
            val __launchId : String?
            if (bundle.containsKey("launchId")) {
                __launchId = bundle.getString("launchId")
                if (__launchId == null) {
                    throw IllegalArgumentException("Argument \"launchId\" is marked as non-null but was passed a null value.")
                }
            } else {
                throw IllegalArgumentException("Required argument \"launchId\" is missing and does not have an android:defaultValue")
            }
            return LaunchDetailsFragmentArgs(__launchId)
        }
    }
}