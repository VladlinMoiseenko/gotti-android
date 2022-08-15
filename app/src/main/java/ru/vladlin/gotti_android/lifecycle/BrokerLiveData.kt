package ru.vladlin.gotti_android.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class BrokerLiveData
{
    companion object {
        fun <A> brokerLiveData(a: LiveData<A>): LiveData<A> {
            return MediatorLiveData<A>().apply {
                var liveDataA: A? = null

                fun update() {
                    if (liveDataA != null)
                        this.value = liveDataA!!
                }

                addSource(a) {
                    liveDataA = it
                    update()
                }

            }
        }
    }
}