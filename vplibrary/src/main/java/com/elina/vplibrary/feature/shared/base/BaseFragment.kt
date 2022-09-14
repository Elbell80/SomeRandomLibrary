package com.elina.vplibrary.feature.shared.base

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<V : MvpView, P : MvpPresenter<V>> : MvpFragment<V, P>(), BaseView {
    protected var compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
    }

    override fun onDestroy() {
        compositeDisposable?.dispose()
        super.onDestroy()
    }
}