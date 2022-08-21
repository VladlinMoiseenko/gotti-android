package ru.vladlin.gotti_android.data.animation.dataStore

import retrofit2.Response
import ru.vladlin.gotti_android.domain.model.AnimationList

interface NetAnimationDataStore {

    suspend fun getAnimations(): Response<AnimationList>
}