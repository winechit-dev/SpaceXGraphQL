package com.winechitpaing.apollographql.ui.launchs

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.winechitpaing.apollographql.R
import com.winechitpaing.apollographql.common.activity.BaseActivity
import com.winechitpaing.apollographql.common.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LaunchsActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var viewModel : LaunchsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel.navigationController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
    }

}