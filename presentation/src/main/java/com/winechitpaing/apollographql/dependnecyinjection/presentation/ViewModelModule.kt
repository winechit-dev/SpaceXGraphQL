package com.winechitpaing.apollographql.dependnecyinjection.presentation

import androidx.lifecycle.ViewModel
import com.winechitpaing.apollographql.launchList.LaunchListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LaunchListViewModel::class)
    abstract fun launchListViewModel(launchListViewModel: LaunchListViewModel): ViewModel

}