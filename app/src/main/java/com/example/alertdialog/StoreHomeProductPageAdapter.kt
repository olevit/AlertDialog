package com.example.alertdialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class StoreHomeProductPageAdapter (private val images: ArrayList<String>, private val callback: StoreHomeProductPageCallback) :
        RecyclerView.Adapter<StoreHomeProductPageVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHomeProductPageVH {
        return   StoreHomeProductPageVH(LayoutInflater.from(parent.context).inflate(
                R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: StoreHomeProductPageVH, position: Int) {
        holder.bind(images[position], position, callback)
    }

    override fun getItemCount(): Int = images.size

}




