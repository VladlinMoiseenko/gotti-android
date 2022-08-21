package ru.vladlin.gotti_android.data.animation.dataStore.source

import retrofit2.Response
import ru.vladlin.gotti_android.data.animation.dataStore.NetAnimationDataStore
import ru.vladlin.gotti_android.data.source.retrofit.ApiService
import ru.vladlin.gotti_android.data.utils.BaseDataSource
import ru.vladlin.gotti_android.domain.model.AnimationList

class RetrofitDataStore(
    val apiService: ApiService
    ) : NetAnimationDataStore, BaseDataSource()
{

    override suspend fun getAnimations(): Response<AnimationList>
    {
        return apiService.getAllAnimations()
    }
}