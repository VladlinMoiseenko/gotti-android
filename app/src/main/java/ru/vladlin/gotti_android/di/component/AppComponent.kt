package ru.vladlin.gotti_android.di.component

import android.content.Context
import dagger.Component
import ru.vladlin.gotti_android.di.scope.AppScope
import ru.vladlin.gotti_android.App
import ru.vladlin.gotti_android.data.network.NetworkErrorInteractor
import ru.vladlin.gotti_android.data.source.retrofit.ApiService
import ru.vladlin.gotti_android.di.module.AppModule
import ru.vladlin.gotti_android.di.module.NetworkModule
import ru.vladlin.gotti_android.di.module.RetrofitModule

@AppScope
@Component(modules = [
    AppModule::class,
    RetrofitModule::class,
    NetworkModule::class
])

interface AppComponent
{
    fun context(): Context
    fun apiService(): ApiService
    fun networkInteractor(): NetworkErrorInteractor
    fun inject(app: App)
    fun activityComponent(): ActivityComponent.Builder
}