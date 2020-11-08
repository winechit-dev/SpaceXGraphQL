package com.winechitpaing.apollographql.common.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.winechitpaing.apollographql.common.viewmodels.SampleViewModelFactory
import com.winechitpaing.apollographql.di.fragment.PresentationComponent
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: SampleViewModelFactory

    @Inject
    lateinit var presentationBuilder: PresentationComponent.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

    }
}