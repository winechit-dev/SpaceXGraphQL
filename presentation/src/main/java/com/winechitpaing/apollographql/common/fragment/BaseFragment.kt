package com.winechitpaing.apollographql.common.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import com.winechitpaing.apollographql.common.activity.BaseActivity
import com.winechitpaing.apollographql.common.viewmodels.SampleViewModelFactory
import com.winechitpaing.apollographql.di.fragment.SaveStateModule
import javax.inject.Inject

abstract class BaseFragment : Fragment(){

    @Inject
    lateinit var viewModelFactory: SampleViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as BaseActivity).presentationBuilder
            .include(SaveStateModule(this))
            .build()
            .inject(this)
    }
}