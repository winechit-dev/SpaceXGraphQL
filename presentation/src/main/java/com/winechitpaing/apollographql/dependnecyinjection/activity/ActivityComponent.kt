package com.winechitpaing.apollographql.dependnecyinjection.activity

import androidx.appcompat.app.AppCompatActivity
import com.winechitpaing.apollographql.dependnecyinjection.presentation.PresentationComponent
import com.winechitpaing.apollographql.dependnecyinjection.presentation.PresentationModule
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity: AppCompatActivity): Builder
        fun build(): ActivityComponent
    }

}