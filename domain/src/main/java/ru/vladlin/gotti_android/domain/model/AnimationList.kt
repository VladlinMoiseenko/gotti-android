package ru.vladlin.gotti_android.domain.model



data class AnimationList(
    val info: Info,
    val results: List<AnimationModel>
)

data class Info( //"last_page":1,"limit":10,"page":1,"total":12
    val total: Int,

//    val count: Int,
//    val next: String?,
//    val pages: Int,
//    val prev: String?
)