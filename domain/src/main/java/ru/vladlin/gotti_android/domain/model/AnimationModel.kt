package ru.vladlin.gotti_android.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnimationModel(
    @Json(name = "_id") val id: String,
    @Json(name = "animationName") val animationName: String?,
    @Json(name = "animationlottie") val animationlottie: String?
)
