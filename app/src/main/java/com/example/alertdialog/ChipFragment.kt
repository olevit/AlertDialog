package com.example.alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alertdialog.databinding.ChipFragmentBinding
import com.example.alertdialog.databinding.FragmentBigPhotoBinding
import com.squareup.picasso.Picasso

class ChipFragment : Fragment(){
    lateinit var binding: ChipFragmentBinding


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = ChipFragmentBinding.inflate(layoutInflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
    }
}