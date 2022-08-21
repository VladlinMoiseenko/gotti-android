package ru.vladlin.gotti_android.ui

import com.github.terrakok.modo.android.AppScreen
import com.github.terrakok.modo.android.MultiAppScreen
import kotlinx.parcelize.Parcelize
import ru.vladlin.gotti_android.ui.fragmentAnimation.FragmentAnimation

object Screens {

    @Parcelize
    class Animation : AppScreen("FragmentAnimation") {
        override fun create() = FragmentAnimation()
    }

    fun MultiStack() = MultiAppScreen(
        "MultiStack",
        listOf(Animation()),
        0
    )
}