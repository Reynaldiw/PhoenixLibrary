package com.reynaldiwijaya.phoenix.utils.extensions

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.onClick(action: (view: View) -> Unit) {
    setOnClickListener(action)
}

fun ImageView.setImageResource(ctx: Context, imageRes: Int) {
    Glide.with(ctx)
        .load(imageRes)
        .into(this)
}

fun ImageView.setImageUrl(c: Context, imageUrl: String) {
    Glide.with(c)
        .load(imageUrl)
        .into(this)
}