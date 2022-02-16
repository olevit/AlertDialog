package com.example.alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alertdialog.databinding.FragmentSearchBinding
import com.github.chrisbanes.photoview.OnViewDragListener
import com.github.chrisbanes.photoview.OnViewTapListener
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.squareup.picasso.Picasso


class SearchFragment : Fragment(), OnViewTapListener{
    lateinit var binding: FragmentSearchBinding

    //lateinit var listProgram: ArrayList<ProgramData>
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                //Picasso.get().load("https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000")
                //.into(binding.productImageView)
        //val photoView = PhotoViewAttacher(binding.productImageView)
        Picasso.get().load("https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000")
                .into(binding.productImageView)
        binding.productImageView.setOnViewTapListener(this)

    }

    override fun onViewTap(view: View?, x: Float, y: Float) {
        findNavController().popBackStack()
    }

}