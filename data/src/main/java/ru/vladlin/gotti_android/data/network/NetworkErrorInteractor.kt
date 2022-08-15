package ru.vladlin.gotti_android.data.network

interface NetworkErrorInteractor
{
    fun getError(ex: Throwable): String
}