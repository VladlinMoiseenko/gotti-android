package ru.vladlin.gotti_android.domain.model



data class AnimationList(
    val last_page: Int,
    val limit: Int,
    val page: Int,
    val total: Int,
    val data: List<AnimationModel>
)

//data class Info(
//    val count: Int,
//    val next: String?,
//    val pages: Int,
//    val prev: String?
//)