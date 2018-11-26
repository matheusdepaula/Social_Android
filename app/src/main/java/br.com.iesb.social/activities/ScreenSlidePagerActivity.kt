package br.com.iesb.social.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import br.com.iesb.social.R
import br.com.iesb.social.animations.DepthPageTransformer
import br.com.iesb.social.fragments.ScreenSlidePageFragment
import br.com.iesb.social.animations.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.support.v4.view.ViewPager.OnPageChangeListener

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

        mPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                onPageChange(position)
            }
        })

//        mPager.setPageTransformer(true, DepthPageTransformer())
    }

    override fun onBackPressed() {

        //Controls the pager flow
        if (mPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            mPager.currentItem = mPager.currentItem - 1
        }
    }

    fun onPageChange(position: Int) {
        restorePageItems()

        var mIndicator = getIndicatorByPosition(position)
        val context = this@ScreenSlidePagerActivity

        val mDrawable = ContextCompat.getDrawable(context, R.drawable.checked_circle)

        mDrawable?.let {
            mIndicator.setBackground(it)
        }
    }

    fun getIndicatorByPosition(position: Int): View {

        return when(position) {
            0 -> indicator1
            1 -> indicator2
            2 -> indicator3
            3 -> indicator4
            else -> indicator1
        }
    }

    fun restorePageItems() {
        val mDrawable = ContextCompat.getDrawable(this, R.drawable.circle)

        mDrawable?.let {
            indicator1.setBackground(it)
            indicator2.setBackground(it)
            indicator3.setBackground(it)
            indicator4.setBackground(it)
        }
    }

    fun getTitleByPosition(position: Int): String {
        return when(position){
            0 -> "Primeira"
            1 -> "Segunda"
            2 -> "Terceira"
            3 -> "Quarta"
            else -> "Outra"
        }
    }

    /**
     * A simple pager adapter that represents 4 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = NUMBER_OF_PAGES

        override fun getItem(position: Int): Fragment {
            val page = ScreenSlidePageFragment.instance(position, getTitleByPosition(position), "LoremInopu soihfa djfnc!")
            return page
        }
    }
}