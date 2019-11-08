package com.reynaldiwijaya.phoenixlibrary.presentation.adapter

import androidx.fragment.app.FragmentManager
import com.reynaldiwijaya.phoenix.base.BaseFragment
import com.reynaldiwijaya.phoenix.presentation.adapter.BasePagerAdapter

class PagerAdapter(fm : FragmentManager, fragments: List<BaseFragment>, titles: List<String> = mutableListOf()) :
    // Extend BasePagerAdapter from PhoenixLibrary
    BasePagerAdapter<BaseFragment>(fm, fragments, titles) {

    override fun getItem(position: Int): BaseFragment = fragments[position]
}