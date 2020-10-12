package com.winechitpaing.apollographql

import android.app.Application
import com.winechitpaing.apollographql.di.app.AppComponent
import com.winechitpaing.apollographql.di.app.AppModule
import com.winechitpaing.apollographql.di.app.DaggerAppComponent

class SpaceXApplication :  Application(){

    val appComponent : AppComponent by lazy{
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}