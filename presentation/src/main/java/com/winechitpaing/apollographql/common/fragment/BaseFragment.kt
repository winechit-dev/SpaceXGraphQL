package com.winechitpaing.apollographql.common.fragment

import androidx.fragment.app.Fragment
import com.winechitpaing.apollographql.common.activity.BaseActivity
import com.winechitpaing.apollographql.di.presentation.PresentationModule

abstract class BaseFragment : Fragment(){

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(
            PresentationModule(this)
        )
    }

    protected val injector get() = presentationComponent
}