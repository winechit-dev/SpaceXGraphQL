package com.winechitpaing.apollographql.di.presentation

import com.winechitpaing.apollographql.di.presentation.modules.PresentationModule
import com.winechitpaing.apollographql.di.presentation.modules.ViewModelModule
import com.winechitpaing.apollographql.ui.launchs.LaunchsActivity
import com.winechitpaing.apollographql.ui.launchs.LaunchsFragment
import com.winechitpaing.apollographql.ui.launchs.LaunchDetailFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class, ViewModelModule::class])
interface PresentationComponent {
    fun inject(fragment: LaunchsFragment)
    fun inject(fragment: LaunchDetailFragment)
    fun inject(activity : LaunchsActivity)
}