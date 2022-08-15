package ru.vladlin.gotti_android.network

import android.content.Context
import ru.vladlin.gotti_android.R
import ru.vladlin.gotti_android.data.network.NetworkErrorInteractor
import java.net.UnknownHostException

class NetworkErrorInteractorImpl(val context: Context) : NetworkErrorInteractor
{
    override fun getError(ex: Throwable): String
    {
        when (ex)
        {
            is UnknownHostException -> {
                return context.resources.getString(R.string.no_internet)
            }
            else -> {
                return context.resources.getString(R.string.no_internet)
            }
        }
    }
}