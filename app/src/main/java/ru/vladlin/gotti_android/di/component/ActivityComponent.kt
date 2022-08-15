package ru.vladlin.gotti_android.di.component

import dagger.Subcomponent
import ru.vladlin.gotti_android.di.module.ActivityModule
import ru.vladlin.gotti_android.di.module.ViewModelModule
import ru.vladlin.gotti_android.di.scope.ActivityScope
import ru.vladlin.gotti_android.ui.MainActivity

@ActivityScope
@Subcomponent(modules = [
    ActivityModule::class,
    ViewModelModule::class
])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun feedComponent(): FeedComponent.Builder

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(module: ActivityModule):Builder
        fun build(): ActivityComponent
    }
}