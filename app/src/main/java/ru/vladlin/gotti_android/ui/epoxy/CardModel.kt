package ru.vladlin.gotti_android.ui.epoxy

import android.content.Context
import android.content.res.Resources
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.vladlin.gotti_android.R
import ru.vladlin.gotti_android.databinding.ComponentCardBinding

@EpoxyModelClass(layout = R.layout.component_card)
abstract class CardModel : EpoxyModelWithHolder<CardModel.CardHolder>() {

    @field:EpoxyAttribute
    open var title: CharSequence? = null

    class CardHolder : EpoxyHolder() {
        lateinit var resources: Resources
        lateinit var context: Context
        lateinit var binding: ComponentCardBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentCardBinding.bind(itemView)
            resources = itemView.resources
            context = itemView.context.applicationContext
        }
    }

    override fun bind(holder: CardHolder) {
        holder.binding.apply {
            materialTextViewTitle.text = title
        }
    }

}