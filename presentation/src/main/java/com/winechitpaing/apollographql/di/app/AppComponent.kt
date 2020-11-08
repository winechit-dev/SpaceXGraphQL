package com.winechitpaing.apollographql.di.app

import android.app.Application
import com.winechitpaing.apollographql.SpaceXApplication
import com.winechitpaing.apollographql.di.activity.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@AppScope
@Component(modules = [AndroidInjectionModule::class,AppModule::class])
interface AppComponent: AndroidInjector<SpaceXApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

}