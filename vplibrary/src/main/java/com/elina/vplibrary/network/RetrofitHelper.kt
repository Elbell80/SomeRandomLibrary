package com.elina.vplibrary.network

import android.content.Context
import com.elina.vplibrary.BuildConfig
import com.elina.vplibrary.utils.constants.ApiConstants
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitHelper {
    private var apiService: ApiService? = null
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    companion object {
        private var retrofitHelper: RetrofitHelper? = null

        fun getInstance(): RetrofitHelper? {
            if (retrofitHelper == null) {
                retrofitHelper = RetrofitHelper()
            }
            return retrofitHelper
        }

        fun init(context: Context) {
            retrofitHelper = RetrofitHelper()
        }
    }

    fun getInstance(): ApiService? {
        if (apiService == null) {
            RetrofitHelper()
        }
        return apiService
    }

    init {
        val gson = GsonBuilder().setLenient().create()

        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(ApiConstants.baseUrl)
            .client(getOkHttpClient())
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(loggingInterceptor)
        }
        return okHttpClient.build()
    }
}