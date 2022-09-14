package com.elina.vplibrary.feature.home

import com.elina.vplibrary.feature.shared.base.BaseView
import com.elina.vplibrary.feature.shared.model.Products

interface HomeView : BaseView {
    fun showToast(errorMsg: String?)
    fun showProductsInView(productsList: List<Products>?)
}