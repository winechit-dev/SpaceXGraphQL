package com.winechitpaing.apollographql.di.activity

import com.winechitpaing.apollographql.di.fragment.PresentationComponent
import com.winechitpaing.apollographql.ui.launchs.LaunchsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [PresentationComponent::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeActivity(): LaunchsActivity

}

