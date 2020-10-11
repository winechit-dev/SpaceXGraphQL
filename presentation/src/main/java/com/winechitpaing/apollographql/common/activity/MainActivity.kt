package com.winechitpaing.apollographql.common.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.winechitpaing.apollographql.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenResumed {
          /*  val response = apolloClient(this@MainActivity).query(LaunchListQuery()).toDeferred().await()

            Log.d("LaunchList", "Success ${response.data}")*/
        }

    }
}