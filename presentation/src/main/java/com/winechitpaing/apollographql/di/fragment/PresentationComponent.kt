package com.winechitpaing.apollographql.di.fragment

import com.winechitpaing.apollographql.common.fragment.BaseFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [SaveStateModule::class])
interface PresentationComponent: AndroidInjector<BaseFragment>{

    @Subcomponent.Builder
    interface Builder{

        fun include(saveStateModule: SaveStateModule): Builder

        fun build(): PresentationComponent

    }
}