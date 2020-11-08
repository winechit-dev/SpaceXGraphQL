package com.winechitpaing.apollographql.di.app

import com.winechitpaing.apollographql.SpaceXApplication
import com.winechitpaing.apollographql.di.activity.ActivityModule
import com.winechitpaing.apollographql.di.data.DataModule
import com.winechitpaing.apollographql.di.domain.DomainModule
import com.winechitpaing.apollographql.di.presentation.modules.SampleViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [DataModule::class, DomainModule::class, ActivityModule::class, SampleViewModelModule::class])
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun contributeApp(): SpaceXApplication

}