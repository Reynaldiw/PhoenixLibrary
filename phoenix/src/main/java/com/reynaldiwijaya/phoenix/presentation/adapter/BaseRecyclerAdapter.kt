package com.reynaldiwijaya.phoenix.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reynaldiwijaya.phoenix.presentation.adapter.viewholder.BaseItemViewHolder
import java.util.*

abstract class BaseRecyclerAdapter<Data, Holder : BaseItemViewHolder<Data>> :
    RecyclerView.Adapter<Holder> {

    protected var mContext: Context
    var mData: MutableList<Data>
    protected var mItemClickListener: OnItemClickListener? = null
    protected var mLongItemClickListener: OnLongItemClickListener? = null

    constructor(context: Context) {
        this.mContext = context
        mData = ArrayList()
    }

    constructor(context: Context, data: MutableList<Data>) {
        this.mContext = context
        this.mData = data
    }

    protected fun getView(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(mContext).inflate(getItemResourceLayout(viewType), parent, false)
    }

    protected abstract fun getItemResourceLayout(viewType: Int): Int

    override fun getItemId(position: Int): Long = position.toLong()

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        try {
            return mData.size
        } catch (e: Exception) {
            return 0
        }
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.mItemClickListener = itemClickListener
    }

    fun setOnLongItemClickListener(longItemClickListener: OnLongItemClickListener) {
        this.mLongItemClickListener = longItemClickListener
    }

    fun getAllData(): List<Data> {
        return mData
    }

    fun add(item: Data) {
        mData.add(item)
        notifyItemInserted(mData.size - 1)
    }

    fun addAll(items: List<Data>) {
        add(items)
    }

    fun add(item: Data, position: Int) {
        mData.add(position, item)
        notifyItemInserted(position)
    }

    fun add(items: List<Data>) {
        val size = items.size
        for (i in 0 until size) {
            mData.add(items[i])
        }
        notifyDataSetChanged()
    }

    fun addOrUpdate(item: Data) {
        val i = mData.indexOf(item)
        if (i > 0) {
            mData[i] = item
            notifyItemChanged(i)
        } else {
            add(item)
        }
    }

    fun addOrUpdate(items: List<Data>) {
        val size = items.size
        for (i in 0 until size) {
            val item = items[i]
            val x = mData.indexOf(item)
            if (x >= 0) {
                mData[x] = item
            } else {
                add(item)
            }
        }
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        if (position >= 0 && position < mData.size) {
            mData.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun remove(item: Data) {
        val position = mData.indexOf(item)
        remove(position)
    }

    fun clear() {
        mData.clear()
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    interface OnLongItemClickListener {
        fun onLongItemClick(view: View, position: Int)
    }

}