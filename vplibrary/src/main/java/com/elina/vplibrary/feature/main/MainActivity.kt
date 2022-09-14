package com.elina.vplibrary.feature.main

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.elina.vplibrary.R
import com.elina.vplibrary.feature.home.HomeFragment
import com.elina.vplibrary.feature.more.MoreFragment
import com.elina.vplibrary.feature.offer.OfferFragment
import com.elina.vplibrary.feature.shared.adapter.TabAdapter
import com.elina.vplibrary.feature.shared.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {
    private var homeFragment: HomeFragment? = null
    private var offerFragment: OfferFragment? = null
    private var moreFragment: MoreFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNav()
        initViewPager()
        initVPPageChange()
    }

    override fun createPresenter() = MainPresenter()

    private fun initViewPager() {
        val tabAdapter = TabAdapter(supportFragmentManager)
        if (homeFragment == null) {
            homeFragment = HomeFragment()
        }
        tabAdapter.addFragment(homeFragment!!, getString(R.string.home), "home")
        if (offerFragment == null) {
            offerFragment = OfferFragment()
        }
        tabAdapter.addFragment(offerFragment!!, getString(R.string.offers), "offers")

        if (moreFragment == null) {
            moreFragment = MoreFragment()
        }
        tabAdapter.addFragment(moreFragment!!, getString(R.string.more), "more")
        frmContainer?.adapter = tabAdapter
    }

    private fun initVPPageChange() {
        frmContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> showHomeView()
                    1 -> showOffers()
                    2 -> showMore()
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun showHomeView() {
        frmContainer.currentItem = 0
        bnvItems.menu.getItem(0).isChecked = true
    }

    private fun showOffers() {
        frmContainer.currentItem = 1
        bnvItems.menu.getItem(1).isChecked = true
    }

    private fun showMore() {
        frmContainer.currentItem = 2
        bnvItems.menu.getItem(2).isChecked = true
    }

    private fun initBottomNav() {
        bnvItems?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_home -> {
                    showHomeView()
                }
                R.id.item_offers -> {
                    showOffers()
                }
                R.id.item_more -> {
                    showMore()
                }
            }
            true
        }
    }
}