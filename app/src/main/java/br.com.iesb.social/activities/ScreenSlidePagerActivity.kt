package br.com.iesb.social.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import br.com.iesb.social.R
import br.com.iesb.social.animations.DepthPageTransformer
import br.com.iesb.social.fragments.ScreenSlidePageFragment
import br.com.iesb.social.animations.ZoomOutPageTransformer

/**
 * Number of pages to show
 */
private const val NUMBER_OF_PAGES = 4

class ScreenSlidePagerActivity: FragmentActivity() {

    private lateinit var mPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        mPager = findViewById(R.id.viewPager)

        //This provides the pages to the view pager widget
        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        mPager.adapter = pagerAdapter

        mPager.setPageTransformer(true, DepthPageTransformer())
    }

    override fun onBackPressed() {

        //Controls the pager flow
        if (mPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            mPager.currentItem = mPager.currentItem - 1
        }
    }

    /**
     * A simple pager adapter that represents 4 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = NUMBER_OF_PAGES

        override fun getItem(position: Int): Fragment = ScreenSlidePageFragment()
    }
}