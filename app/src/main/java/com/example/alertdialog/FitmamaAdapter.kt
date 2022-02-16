package com.example.alertdialog

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FitmamaAdapter (fa: FragmentActivity, val list:Array<String>) : FragmentStateAdapter(fa) {

        override fun getItemCount(): Int {
            return list.size
        }

        override fun createFragment(position: Int): Fragment {
            return BigPhotoFragment(list[position])
        }
}