package ru.vladlin.gotti_android.domain.boundaries

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import ru.vladlin.gotti_android.domain.model.AnimationList

interface AnimationNetworkInteractor {
    fun getAllNetAnimations(): Flow<Response<AnimationList>>
}