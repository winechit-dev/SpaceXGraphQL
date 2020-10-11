package com.winechitpaing.apollographql.di.presentation

import com.winechitpaing.apollographql.di.presentation.modules.DataModule
import com.winechitpaing.apollographql.di.presentation.modules.PresentationModule
import com.winechitpaing.apollographql.di.presentation.modules.ViewModelModule
import com.winechitpaing.apollographql.ui.launchList.LaunchListActivity
import com.winechitpaing.apollographql.ui.launchList.LaunchListFragment
import com.winechitpaing.apollographql.ui.launchList.LaunchPastDetailFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class, DataModule::class, ViewModelModule::class])
interface PresentationComponent {
    fun inject(fragment: LaunchListFragment)
    fun inject(fragment: LaunchPastDetailFragment)
    fun inject(activity : LaunchListActivity)
}