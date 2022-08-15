package ru.vladlin.gotti_android.di.module

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import ru.vladlin.gotti_android.data.network.NetworkErrorInteractor
import ru.vladlin.gotti_android.di.scope.AppScope
import ru.vladlin.gotti_android.network.NetworkErrorInteractorImpl
import ru.vladlin.gotti_android.di.MoshiNetwork

@Module
class NetworkModule
{
    @Provides
    @AppScope
    fun provideNetworkInteractor(context: Context): NetworkErrorInteractor = NetworkErrorInteractorImpl(context)

    @Provides
    @MoshiNetwork
    fun provideMoshi(builder: Moshi.Builder): Moshi {
        return builder
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}