package com.elina.vplibrary.feature.shared.repository

import android.annotation.SuppressLint
import com.elina.vplibrary.feature.shared.model.Products
import com.elina.vplibrary.network.RetrofitHelper
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io

class HomeRepository {
    private val retrofitHelper = RetrofitHelper.getInstance()
    private val apiService = retrofitHelper?.getInstance()

    @SuppressLint("CheckResult")
    fun getProducts(): Single<List<Products>> = Single.create { e ->
        apiService?.getProductsForHome()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ response ->
                if (response.isSuccessful && response.body().data != null) {
                    e.onSuccess(response.body()?.data!!)
                } else {
                    e.onError(Throwable("Something went wrong!!!"))
                }
            }, {
                e.onError(Throwable(it.localizedMessage))
            })
    }
}