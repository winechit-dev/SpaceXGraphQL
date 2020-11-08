package com.winechitpaing.apollographql.di.fragment

import androidx.fragment.app.Fragment
import androidx.savedstate.SavedStateRegistryOwner
import dagger.Module
import dagger.Provides

@Module
class SaveStateModule (private val savedStateRegistryOwner: SavedStateRegistryOwner){

    @Provides
    fun provideSaveStateRegistryOwner() = savedStateRegistryOwner
}