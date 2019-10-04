package ng.mathemandy.core.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<ITEM: Any?>(binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
    abstract fun bindItem(item: ITEM?)
}