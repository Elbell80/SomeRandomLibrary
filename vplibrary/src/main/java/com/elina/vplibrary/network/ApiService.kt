package com.elina.vplibrary.network

import com.elina.vplibrary.feature.shared.model.ProductsResponse
import com.elina.vplibrary.utils.constants.ApiConstants
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(ApiConstants.getProducts)
    fun getProductsForHome(): Single<Response<ProductsResponse>>
}