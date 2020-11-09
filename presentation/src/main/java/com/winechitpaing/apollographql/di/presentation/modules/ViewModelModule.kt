package com.winechitpaing.apollographql.di.presentation.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.winechitpaing.apollographql.di.presentation.ViewModelKey
import com.winechitpaing.apollographql.ui.launchs.LaunchsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LaunchsViewModel::class)
    abstract fun launchListViewModel(launchsViewModel: LaunchsViewModel): ViewModel

}

class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        requireNotNull(creator) { "unknown model class $modelClass" }
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}