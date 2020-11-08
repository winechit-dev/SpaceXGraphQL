package com.winechitpaing.apollographql.di.presentation.modules

import androidx.lifecycle.ViewModel
import com.winechitpaing.apollographql.di.presentation.ViewModelKey
import com.winechitpaing.apollographql.ui.launchs.LaunchsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SampleViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LaunchsViewModel::class)
    abstract fun launchListViewModel(launchsViewModel: LaunchsViewModel): ViewModel

}