package com.winechitpaing.apollographql.dependnecyinjection.app

import com.winechitpaing.apollographql.dependnecyinjection.activity.ActivityComponent
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponentBuilder(): ActivityComponent.Builder


}