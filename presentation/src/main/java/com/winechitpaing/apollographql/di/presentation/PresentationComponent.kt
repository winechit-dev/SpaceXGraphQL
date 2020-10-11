package com.winechitpaing.apollographql.di.presentation

import com.winechitpaing.apollographql.ui.launchList.LaunchListActivity
import com.winechitpaing.apollographql.ui.launchList.LaunchListFragment
import com.winechitpaing.apollographql.ui.launchList.LaunchPastDetailFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class, ViewModelModule::class])
interface PresentationComponent {
    fun inject(fragment: LaunchListFragment)
    fun inject(fragment: LaunchPastDetailFragment)
    fun inject(activity : LaunchListActivity)
}