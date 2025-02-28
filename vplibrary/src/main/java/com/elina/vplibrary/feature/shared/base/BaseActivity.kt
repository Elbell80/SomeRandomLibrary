package com.elina.vplibrary.feature.shared.base

import androidx.appcompat.app.AppCompatActivity
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

abstract class BaseActivity<V : MvpView, P : MvpPresenter<V>> : MvpActivity<V, P>(), BaseView {
}