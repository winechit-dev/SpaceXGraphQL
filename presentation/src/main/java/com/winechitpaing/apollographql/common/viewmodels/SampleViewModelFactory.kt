package com.winechitpaing.apollographql.common.viewmodels

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class SampleViewModelFactory @Inject constructor(
    private val providersMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val provider = providersMap[modelClass]
        val viewModel =
            provider?.get() ?: throw RuntimeException("unsupported viewmodel type: $modelClass")

        return viewModel as T
    }
}