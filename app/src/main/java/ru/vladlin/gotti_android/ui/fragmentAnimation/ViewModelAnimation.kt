package ru.vladlin.gotti_android.ui.fragmentAnimation

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Response
import ru.vladlin.gotti_android.data.network.NetworkErrorInteractor
import ru.vladlin.gotti_android.domain.boundaries.AnimationNetworkInteractor
import ru.vladlin.gotti_android.domain.model.AnimationList
import ru.vladlin.gotti_android.domain.model.AnimationModel
import ru.vladlin.gotti_android.lifecycle.BrokerLiveData
import ru.vladlin.gotti_android.lifecycle.SingleLiveEvent
import javax.inject.Inject

class ViewModelAnimation @Inject constructor(
    val animationNetworkInteractor: AnimationNetworkInteractor,
    val networkErrorInteractor: NetworkErrorInteractor,
    val context: Context
): ViewModel()  {

    private val feedAll: MutableLiveData<List<AnimationModel>> = MutableLiveData()

    val dataFeed = BrokerLiveData.brokerLiveData(feedAll)

    var isRefreshed: MutableLiveData<Boolean> = MutableLiveData()
    val errorFeed: SingleLiveEvent<String?> = SingleLiveEvent()
    val errorSnackbar: SingleLiveEvent<String> = SingleLiveEvent()

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            loadAllAnimations()
        }
    }

    private suspend fun loadAllAnimations() {
        val flow: Flow<Response<AnimationList>> = animationNetworkInteractor.getAllNetAnimations()
        flow
            .flowOn(Dispatchers.IO)
            .catch {
                if (feedAll.value.isNullOrEmpty())
                    errorFeed.postValue(networkErrorInteractor.getError(it))
                else
                    errorSnackbar.postValue(networkErrorInteractor.getError(it))
            }
            .collect {
                if (it.isSuccessful) {
                    val pg: PagingSource.LoadResult<Int, AnimationModel>
                    pg = PagingSource.LoadResult.Page(
                        data = it.body()?.data!!,
                        prevKey = null,
                        nextKey = null
                    )
                    feedAll.postValue(pg.data)
                } else {
                    errorFeed.postValue(null)
                }
            }
    }
}