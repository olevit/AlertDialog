package com.example.alertdialog

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.alertdialog.databinding.ItemBinding
import com.github.chrisbanes.photoview.OnViewTapListener
import com.squareup.picasso.Picasso

class StoreHomeProductPageVH (itemView: View) : RecyclerView.ViewHolder(itemView){
    private val binding: ItemBinding =
            ItemBinding.bind(itemView)

    fun bind(image: String, position: Int, callback: StoreHomeProductPageCallback) {

        Picasso.get().load(image).into(binding.pvImageProduct)
        binding.pvImageProduct.setOnViewTapListener { view: View, fl: Float, fl1: Float ->
            callback.onImageMiniPhotoClick(position, image) }
    }
}