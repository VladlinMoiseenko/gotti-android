package ru.vladlin.gotti_android.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class BrokerPairLiveData
{
    companion object {
        fun <A, B> brokerLiveData(a: LiveData<A>, b: LiveData<B>): LiveData<Pair<A, B>> {
            return MediatorLiveData<Pair<A, B>>().apply {
                var liveDataA: A? = null
                var liveDataB: B? = null

                fun update() {
                    if (liveDataA != null && liveDataB != null)
                        this.value = Pair(liveDataA!!, liveDataB!!)
                }

                addSource(a) {
                    liveDataA = it
                    update()
                }

                addSource(b) {
                    liveDataB = it
                    update()
                }
            }
        }
    }
}