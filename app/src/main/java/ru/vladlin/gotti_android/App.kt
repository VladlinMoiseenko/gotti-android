package ru.vladlin.gotti_android

import android.app.Application
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.MultiReducer
import com.github.terrakok.modo.android.AppReducer
import com.github.terrakok.modo.android.LogReducer
import ru.vladlin.gotti_android.di.component.AppComponent
import ru.vladlin.gotti_android.di.component.DaggerAppComponent
import ru.vladlin.gotti_android.di.module.AppModule

class App : Application() {

    object DI {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        modo = Modo(LogReducer(AppReducer(this, MultiReducer())))
        super.onCreate()

        DI.appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    companion object {
        lateinit var modo: Modo private set
    }
}