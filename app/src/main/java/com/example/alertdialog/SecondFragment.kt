package com.example.alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alertdialog.databinding.FragmentSecondBinding
import com.google.android.material.tabs.TabLayoutMediator


class SecondFragment: Fragment() {
    lateinit var binding: FragmentSecondBinding

    //lateinit var listProgram: ArrayList<ProgramData>
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        val adapter = PagerAdapter(requireActivity())
        binding.vp2Home.adapter = adapter
        TabLayoutMediator(binding.tabLayoutHome, binding.vp2Home) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Daily"

                }
                1 -> {
                    tab.text = "Focused"

                }
                2 ->{
                    tab.text ="Search"
                    tab.setIcon(R.drawable.ic_launcher_foreground)
                }
            }
        }.attach()


        return binding.root
    }


}