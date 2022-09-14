package com.elina.vplibrary.feature.shared.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : BaseView> : MvpBasePresenter<V>() {
    protected var compositeDisposable: CompositeDisposable? = null

    override fun attachView(view: V) {
        super.attachView(view)
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView() {
        compositeDisposable?.dispose()
        super.detachView()
    }
}