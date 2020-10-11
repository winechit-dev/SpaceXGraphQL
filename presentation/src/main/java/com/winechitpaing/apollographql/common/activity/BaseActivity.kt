package com.winechitpaing.apollographql.common.activity

import androidx.appcompat.app.AppCompatActivity
import com.winechitpaing.apollographql.SpaceXApplication
import com.winechitpaing.apollographql.di.presentation.modules.PresentationModule

abstract class BaseActivity : AppCompatActivity(){
     val appComponent get() = (application as SpaceXApplication).appComponent

    val activityComponent by lazy {
        appComponent.newActivityComponentBuilder()
            .activity(this)
            .build()
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule(this))
    }

    protected val injector get() = presentationComponent
}