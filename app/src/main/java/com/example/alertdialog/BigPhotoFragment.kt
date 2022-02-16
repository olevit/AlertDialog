package com.example.alertdialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alertdialog.databinding.DialogMyBinding
import com.example.alertdialog.databinding.FragmentBigPhotoBinding
import com.example.alertdialog.databinding.FragmentFirstBinding
import com.github.chrisbanes.photoview.OnSingleFlingListener
import com.github.chrisbanes.photoview.OnViewDragListener
import com.github.chrisbanes.photoview.OnViewTapListener
import com.squareup.picasso.Picasso
import kotlin.math.abs

class BigPhotoFragment(val path: String): Fragment() {
    lateinit var binding: FragmentBigPhotoBinding


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentBigPhotoBinding.inflate(layoutInflater)
        Picasso.get().load(path).into(binding.pvPhotoProduct)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pvPhotoProduct.setOnSingleFlingListener(onSingleFlingListenerPV)

    }
    private val onSingleFlingListenerPV = OnSingleFlingListener { e1, e2, velocityX, velocityY ->
        try {
            val diffY = e2?.y!! - e1?.y!!
            if (diffY > 100 && abs(velocityY) > 100) {
                Toast.makeText(requireContext(), "Swipe down gesture detectedokok", Toast.LENGTH_SHORT)
                        .show()
                findNavController().navigate(R.id.firstFragment)

            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        false
    }
    }



   /* override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        try {
            val diffY = e2?.y!! - e1?.y!!
            //val diffX = e2.x - e1.x

            if (diffY > 100 && abs(velocityY) > 100) {
                Toast.makeText(requireContext(), "Swipe down gesture detected", Toast.LENGTH_SHORT)
                        .show()
                findNavController().navigate(R.id.secondFragment)

            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        return false
    }
}*/


