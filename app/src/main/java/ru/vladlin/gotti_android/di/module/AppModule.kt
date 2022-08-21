package ru.vladlin.gotti_android.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.vladlin.gotti_android.di.scope.AppScope

@Module
class AppModule (val context: Context)
{
    @Provides
    @AppScope
    fun provideContext(): Context = context
}