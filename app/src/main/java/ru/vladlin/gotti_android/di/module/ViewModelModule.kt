package ru.vladlin.gotti_android.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.vladlin.gotti_android.di.key.ViewModelKey
import ru.vladlin.gotti_android.lifecycle.ViewModelFactory
import ru.vladlin.gotti_android.ui.fragmentAnimation.ViewModelAnimation

@Module
abstract class ViewModelModule
{
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelAnimation::class)
    abstract fun viewModelAnimation(viewModelAnimation: ViewModelAnimation): ViewModel
}