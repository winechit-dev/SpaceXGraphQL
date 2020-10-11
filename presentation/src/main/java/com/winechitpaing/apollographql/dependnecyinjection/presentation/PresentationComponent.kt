package com.winechitpaing.apollographql.dependnecyinjection.presentation

import com.winechitpaing.apollographql.launchList.LaunchListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class, ViewModelModule::class])
interface PresentationComponent {
    fun inject(fragment: LaunchListFragment)
}