package com.reynaldiwijaya.phoenix.presentation.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

abstract class BasePagerAdapter<Fragment : androidx.fragment.app.Fragment> : FragmentPagerAdapter {
    var fragments: List<Fragment>
    var titles: List<String> = emptyList()

    constructor(fm: FragmentManager, fragments: List<Fragment>) : super(fm) {
        this.fragments = fragments
    }

    constructor(fm: FragmentManager, fragments: List<Fragment>, titles: List<String>) : super(fm) {
        this.fragments = fragments
        this.titles = titles
    }

    abstract override fun getItem(position: Int): Fragment

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (titles.size == fragments.size) titles[position] else super.getPageTitle(position)
    }
}