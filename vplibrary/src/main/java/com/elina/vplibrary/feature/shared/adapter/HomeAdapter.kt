package com.elina.vplibrary.feature.shared.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elina.vplibrary.R
import com.elina.vplibrary.feature.shared.ProductVH
import com.elina.vplibrary.feature.shared.model.Products
import com.squareup.picasso.Picasso

class HomeAdapter(var productsList: List<Products>, var context: Context?) :
    RecyclerView.Adapter<ProductVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_product, parent, false)
        return ProductVH(view)
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val products = productsList[position]
        holder.txvProductName?.text = products.name
        holder.txvProductDescription?.text = products.description
        Picasso.get().load(products.categoryIcon).into(holder.imvProduct)
    }

    override fun getItemCount(): Int = productsList.size
}