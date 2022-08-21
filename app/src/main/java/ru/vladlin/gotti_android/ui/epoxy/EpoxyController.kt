package ru.vladlin.gotti_android.ui.epoxy

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import ru.vladlin.gotti_android.domain.model.AnimationModel

class EpoxyController() : TypedEpoxyController<List<AnimationModel>>(
        EpoxyAsyncUtil.getAsyncBackgroundHandler(),
        EpoxyAsyncUtil.getAsyncBackgroundHandler()
    )
{
    override fun buildModels(data: List<AnimationModel>?)
    {
        if (data == null) {
            loaderModelView { id("loader") }
            return
        }

        for (item in data) {
            card {
                id("card-id:$item.id}")
                title(item.animationName)
            }
        }
    }
}
