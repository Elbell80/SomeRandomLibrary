package com.elina.vplibrary.feature.shared

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_product.view.*

class ProductVH(val view: View) : RecyclerView.ViewHolder(view) {
    var txvProductName: TextView? = view.txvProductName
    var txvProductDescription: TextView? = view.txvProductDescription
    var imvProduct: ImageView? = view.imvProduct
}