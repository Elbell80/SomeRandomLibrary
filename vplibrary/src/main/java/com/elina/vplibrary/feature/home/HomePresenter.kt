package com.elina.vplibrary.feature.home

import android.annotation.SuppressLint
import com.elina.vplibrary.feature.shared.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter : BasePresenter<HomeView>() {
    private val homeInteractor = HomeInteractor()

    @SuppressLint("CheckResult")
    fun getProducts() {
        ifViewAttached { view ->
            homeInteractor.getHomeProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showProductsInView(it)
                }, {
                    view.showToast(it.localizedMessage)
                })
        }
    }
}