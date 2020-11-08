package com.winechitpaing.apollographql.ui.launchs

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.Navigation
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.common.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class LaunchsActivity : BaseActivity(){

    private val viewModel : LaunchsViewModel by viewModels{viewModelFactory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        viewModel.navigationController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
    }

}