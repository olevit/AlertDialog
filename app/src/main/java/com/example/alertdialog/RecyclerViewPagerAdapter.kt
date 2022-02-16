package com.example.alertdialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.alertdialog.databinding.FragmentBigPhotoBinding
import com.squareup.picasso.Picasso

class RecyclerViewPagerAdapter(private val array: Array<String>) : RecyclerView.Adapter<RecyclerViewPagerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_big_photo,
                parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun getItemCount() = array.size


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: FragmentBigPhotoBinding = FragmentBigPhotoBinding.bind(itemView)
        fun bind(pathImage: String){
            Picasso.get().load(pathImage).into(binding.pvPhotoProduct)
        }
    }

}
