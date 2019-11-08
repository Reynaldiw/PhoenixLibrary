package com.reynaldiwijaya.phoenixlibrary.presentation.main

import com.reynaldiwijaya.phoenix.base.BaseActivity
import com.reynaldiwijaya.phoenix.base.BaseFragment
import com.reynaldiwijaya.phoenixlibrary.R
import com.reynaldiwijaya.phoenixlibrary.presentation.adapter.PagerAdapter
import com.reynaldiwijaya.phoenixlibrary.presentation.movies.MoviesFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Extend Base Activity
 */
class MainActivity : BaseActivity() {

    private val pagerAdapter: PagerAdapter by lazy {
        PagerAdapter(supportFragmentManager, getFragments(), getTitles())
    }

    private fun getTitles(): List<String> {
        return listOf(
            "Movies",
            "Movies"
        )
    }

    // You have to pass with BaseFragment not Fragment
    private fun getFragments(): List<BaseFragment> {
        return listOf(
            MoviesFragment.newInstance(),
            MoviesFragment.newInstance()
        )
    }

    // Pass your layout here
    override val layoutResource: Int =
        R.layout.activity_main

    //    Init Presenter and Component Injection here
    override fun initAction() {
    }

    //    Extract desired intent here
    override fun initIntent() {
    }

    //    initialize the UI, setup toolbar, setText etc here
    override fun initLib() {
    }

    //    initialize UI interaction here
    override fun initProcess() {
    }

    //    initialize main Process here e.g call presenter to load data
    override fun initUI() {
        setupViewPager()
    }

    private fun setupViewPager() {
        tabMain.tabIconTint = null

        vpMain.adapter = pagerAdapter
        vpMain.offscreenPageLimit = 2
        tabMain.setupWithViewPager(vpMain)
    }
}
