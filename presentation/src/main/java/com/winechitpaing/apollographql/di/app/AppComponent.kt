package com.winechitpaing.apollographql.di.app

import com.winechitpaing.apollographql.di.activity.ActivityComponent
import com.winechitpaing.domain.repository.DataRepository
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponentBuilder(): ActivityComponent.Builder


}