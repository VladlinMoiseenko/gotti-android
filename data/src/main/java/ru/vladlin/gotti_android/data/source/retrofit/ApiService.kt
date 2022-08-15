package ru.vladlin.gotti_android.data.source.retrofit

import ru.vladlin.gotti_android.domain.model.AnimationList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("animation")
    suspend fun getAllAnimations(): Response<AnimationList>

}