package com.example.alertdialog

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSlidePagerAdapter(fa: FragmentActivity, val list: Array<String>) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = list.size



    override fun createFragment(position: Int): Fragment = BigPhotoFragment(list[position])
}