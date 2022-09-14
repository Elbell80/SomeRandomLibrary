package com.elina.vplibrary.feature.shared.model

import com.google.gson.annotations.SerializedName

class Products {
    @SerializedName("id") 
    var id: Int? = null

    @SerializedName("name") 
    var name: String? = null

    @SerializedName("categoryBackgroundImage") 
    var categoryBackgroundImage: String? = null

    @SerializedName("categoryIcon") 
    var categoryIcon: String? = null

    @SerializedName("description") 
    var description: String? = null
}