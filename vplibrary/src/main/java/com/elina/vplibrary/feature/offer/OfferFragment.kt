package com.elina.vplibrary.feature.offer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elina.vplibrary.R
import com.elina.vplibrary.feature.home.HomePresenter
import com.elina.vplibrary.feature.home.HomeView
import com.elina.vplibrary.feature.shared.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class OfferFragment : BaseFragment<OfferView, OfferPresenter>(), OfferView {
    private lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_offer, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun createPresenter() = OfferPresenter()


    private fun initViews(){
        txvTitleHome?.text = getString(R.string.offers)
    }
}