package ru.vladlin.gotti_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.modo.android.ModoRender
import com.github.terrakok.modo.android.saveState
import com.github.terrakok.modo.back
import com.github.terrakok.modo.forward
import ru.vladlin.gotti_android.App
import ru.vladlin.gotti_android.R
import ru.vladlin.gotti_android.di.module.ActivityModule

class MainActivity : AppCompatActivity() {

    private val modo = App.modo

    private val modoRender by lazy {
        object : ModoRender(this@MainActivity, R.id.container) {
        }
    }

    val activitySubComponent by lazy {
        return@lazy App.DI.appComponent
            .activityComponent()
            .activityModule(ActivityModule(this))
            .build()
    }

    val feedComponent by lazy {
        return@lazy activitySubComponent.feedComponent().build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activitySubComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        modo.forward(Screens.Animation())
    }

    override fun onResume() {
        super.onResume()
        modo.render = modoRender
    }

    override fun onPause() {
        modo.render = null
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        modo.saveState(outState)
    }

    override fun onBackPressed() {
        modo.back()
    }
}