package com.reynaldiwijaya.phoenix.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImageUrl(context: Context, url : String, errorView : Int) {
    Picasso.get()
        .load(url)
        .error(errorView)
        .into(this)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}