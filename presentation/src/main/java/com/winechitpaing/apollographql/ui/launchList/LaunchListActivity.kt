package com.winechitpaing.apollographql.ui.launchList

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.common.activity.BaseActivity
import com.winechitpaing.apollographql.common.viewmodels.ViewModelFactory
import javax.inject.Inject

class LaunchListActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var viewModel : LaunchListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_main)

        viewModel.navigationController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
    }
}