package ru.vladlin.gotti_android.domain.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import ru.vladlin.gotti_android.domain.boundaries.AnimationNetworkInteractor
import ru.vladlin.gotti_android.domain.boundaries.AnimationRepo
import ru.vladlin.gotti_android.domain.model.AnimationList

class AnimationNetworkInteractorImpl(val animationRepo: AnimationRepo): AnimationNetworkInteractor {

    override fun getAllNetAnimations(): Flow<Response<AnimationList>> {
        return animationRepo.getAllNetAnimations().flowOn(Dispatchers.IO)
    }

}