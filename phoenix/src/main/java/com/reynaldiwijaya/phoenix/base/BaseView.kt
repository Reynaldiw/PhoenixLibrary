package com.reynaldiwijaya.phoenix.base

import androidx.appcompat.widget.Toolbar

interface BaseView {
    fun setupToolbar(toolbar: Toolbar?, title: String, isChild: Boolean)

    fun setupToolbar(toolbar: Toolbar?, isChild: Boolean)

    fun setupToolbar(title: String, isChild: Boolean)

    fun finishActivity()

    fun hideKeyboard()
}