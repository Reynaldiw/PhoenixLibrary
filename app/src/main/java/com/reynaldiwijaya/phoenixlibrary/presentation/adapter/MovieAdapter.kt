package com.reynaldiwijaya.phoenixlibrary.presentation.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.reynaldiwijaya.phoenix.presentation.adapter.BaseRecyclerAdapter
import com.reynaldiwijaya.phoenix.presentation.adapter.viewholder.BaseItemViewHolder
import com.reynaldiwijaya.phoenix.utils.extensions.setImageUrl
import com.reynaldiwijaya.phoenixlibrary.R
import com.reynaldiwijaya.phoenixlibrary.data.model.MovieItems
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(
    mContext : Context,
    data : MutableList<MovieItems> = mutableListOf())
    // Call method BaseRecycler Adapter from Phoenix Library and parse the model of your data
    // And Your ViewHolder and also parse the context and your data here
    : BaseRecyclerAdapter<MovieItems, MovieAdapter.MovieViewHolder>(mContext, data){

    // You can pass your item layout here
    override fun getItemResourceLayout(viewType: Int): Int = R.layout.item_movie

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            // This parse data from Phoenix Library, you can use like this
            mContext,
            getView(parent, viewType),
            mItemClickListener,
            mLongItemClickListener
        )
    }

    // This is your viewHolder, you have to add to your parameter with context,
    // your view, itemClick, and longItemClick
    inner class MovieViewHolder(
        context: Context,
        itemView : View,
        itemClickListener: OnItemClickListener?,
        onLongItemClickListener: OnLongItemClickListener?
    // You have to extend your ViewHolder with BaseItemViewHolder from Phoenix Library
    // You have to parse your model data and parse object on your parameter to parameter
    // BaseItemViewHolder
    ) : BaseItemViewHolder<MovieItems>(context, itemView, itemClickListener, onLongItemClickListener) {
        // This method for setup data
        override fun bind(data: MovieItems) {
            with(itemView) {
                tvTitle.text = data.title
                tvOverview.text = data.overview
                // You can use ext func in phoenix Library
                imgMovie.setImageUrl(itemView.context, "https://image.tmdb.org/t/p/w500/${data.posterPath}")
            }
        }
    }
}