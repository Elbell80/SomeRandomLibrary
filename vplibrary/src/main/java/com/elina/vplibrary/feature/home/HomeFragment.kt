package com.elina.vplibrary.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.elina.vplibrary.R
import com.elina.vplibrary.feature.shared.adapter.HomeAdapter
import com.elina.vplibrary.feature.shared.base.BaseFragment
import com.elina.vplibrary.feature.shared.model.Products
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeView, HomePresenter>(), HomeView {
    private lateinit var myView: View
    var homeAdapter: HomeAdapter? = null
    var productsList = mutableListOf<Products>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_home, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        getHomeProducts()
    }

    override fun createPresenter() = HomePresenter()

    override fun showProductsInView(productsList: List<Products>?) {
        this.productsList.clear()
        productsList?.let { this.productsList.addAll(it) }
        homeAdapter?.notifyDataSetChanged()
    }

    override fun showToast(errorMsg: String?) {
        Toast.makeText(context, errorMsg, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        rcvHome?.layoutManager = layoutManager
        homeAdapter = HomeAdapter(productsList, context)
        rcvHome?.adapter = homeAdapter
    }

    private fun getHomeProducts() {
        presenter.getProducts()
    }
}