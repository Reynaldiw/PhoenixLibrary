package com.reynaldiwijaya.phoenix.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

abstract class BasePagerAdapter : FragmentPagerAdapter {
    var fragments : List<Fragment>
    var titles : List<String> = emptyList()

    constructor(fm : FragmentManager, fragments: List<Fragment>) : super(fm) {
        this.fragments = fragments
    }

    constructor(fm : FragmentManager, fragments: List<Fragment>, titles : List<String>) : super(fm) {
        this.fragments = fragments
        this.titles = titles
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (titles.size == fragments.size) titles[position] else super.getPageTitle(position)
    }
}