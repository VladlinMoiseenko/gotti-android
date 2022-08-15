package ru.vladlin.gotti_android.data.animation.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import ru.vladlin.gotti_android.data.animation.dataStore.NetAnimationDataStore
import ru.vladlin.gotti_android.domain.boundaries.AnimationRepo
import ru.vladlin.gotti_android.domain.model.AnimationList

class AnimationRepoImpl(
    val netAnimationDataStore: NetAnimationDataStore
) : AnimationRepo
{

    override fun getAllNetAnimations(): Flow<Response<AnimationList>> {
        return flow {
            emit(netAnimationDataStore.getAnimations())
        }.flowOn(Dispatchers.IO)
    }

}