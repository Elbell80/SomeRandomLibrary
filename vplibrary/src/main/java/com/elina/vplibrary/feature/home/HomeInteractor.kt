package com.elina.vplibrary.feature.home

import com.elina.vplibrary.feature.shared.repository.HomeRepository

class HomeInteractor {
    private val homeRepository = HomeRepository()

    fun getHomeProducts() = homeRepository.getProducts()
}