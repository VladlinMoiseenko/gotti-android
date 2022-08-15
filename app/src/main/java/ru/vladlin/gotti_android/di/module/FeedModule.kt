package ru.vladlin.gotti_android.di.module

import dagger.Module
import dagger.Provides
import ru.vladlin.gotti_android.data.animation.dataStore.NetAnimationDataStore
import ru.vladlin.gotti_android.data.animation.dataStore.source.RetrofitDataStore
import ru.vladlin.gotti_android.data.animation.repo.AnimationRepoImpl
import ru.vladlin.gotti_android.data.source.retrofit.ApiService
import ru.vladlin.gotti_android.di.scope.FeedScope
import ru.vladlin.gotti_android.domain.boundaries.AnimationNetworkInteractor
import ru.vladlin.gotti_android.domain.boundaries.AnimationRepo
import ru.vladlin.gotti_android.domain.interactor.AnimationNetworkInteractorImpl


@Module
class FeedModule
{

    @Provides
    @FeedScope
    fun provideAnimationDataStore(apiService: ApiService): NetAnimationDataStore
            = RetrofitDataStore(apiService)

    @Provides
    @FeedScope
    fun provideAnimationNetworkInteractor(animationRepo: AnimationRepo): AnimationNetworkInteractor
            = AnimationNetworkInteractorImpl(animationRepo)


}