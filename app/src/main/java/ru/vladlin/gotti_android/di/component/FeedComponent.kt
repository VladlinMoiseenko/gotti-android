package ru.vladlin.gotti_android.di.component

import dagger.Subcomponent
import ru.vladlin.gotti_android.di.module.FeedModule
import ru.vladlin.gotti_android.di.scope.FeedScope
import ru.vladlin.gotti_android.ui.fragmentAnimation.FragmentAnimation

@FeedScope
@Subcomponent(modules = [
    FeedModule::class
])
interface FeedComponent
{
    @Subcomponent.Builder
    interface Builder {
        fun build(): FeedComponent
    }

    fun inject(fragmentAnimation: FragmentAnimation)
}