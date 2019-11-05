package com.reynaldiwijaya.phoenix.presentation.adapter.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.reynaldiwijaya.phoenix.presentation.adapter.BaseRecyclerAdapter

abstract class BaseItemViewHolder<Data>(protected var mContext : Context,
                                        itemView : View,
                                        private val mItemClickListener : BaseRecyclerAdapter.OnItemClickListener?,
                                        private val mLongItemClickListener : BaseRecyclerAdapter.OnLongItemClickListener?)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    var isHasHeader = false

    init {
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    abstract fun bind(data: Data)

    override fun onClick(v: View) {
        mItemClickListener?.onItemClick(v, if (isHasHeader) adapterPosition - 1 else adapterPosition)
    }

    override fun onLongClick(v: View): Boolean {
        if (mLongItemClickListener != null) {
            mLongItemClickListener.onLongItemClick(v, if (isHasHeader) adapterPosition - 1 else adapterPosition)
            return true
        }
        return false
    }

}