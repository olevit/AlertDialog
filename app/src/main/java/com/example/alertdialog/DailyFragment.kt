package com.example.alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alertdialog.databinding.FragmentDailyBinding
import com.example.alertdialog.databinding.FragmentSecondBinding
import com.github.chrisbanes.photoview.OnViewTapListener
import com.squareup.picasso.Picasso

class DailyFragment : Fragment(){
    lateinit var binding: FragmentDailyBinding
    private val image = arrayListOf(
                "https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000",
                "https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnIUzfCf4fQKF6Ugku9MQQoN9QsWBiESZBdg&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR19AQcA89PsDQB_n4P4s9T9K1p_nLlB-I5kQ&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnIUzfCf4fQKF6Ugku9MQQoN9QsWBiESZBdg&usqp=CAU"
        )

    //lateinit var listProgram: ArrayList<ProgramData>
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDailyBinding.inflate(layoutInflater)


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnIUzfCf4fQKF6Ugku9MQQoN9QsWBiESZBdg&usqp=CAU")
                .into(binding.pvPhotoProduct)
        //binding.pvPhotoProduct.setOnViewTapListener(onViewTapListenerTop)
       /* binding.pvPhotoProduct.setOnViewTapListener { view: View, fl: Float, fl1: Float ->
            findNavController().popBackStack()
        }*/
        binding.pvPhotoProduct.setOnClickListener{
            findNavController().popBackStack()
        }
        binding.rvProduct.adapter = StoreHomeProductPageAdapter(image, object : StoreHomeProductPageCallback {
            override fun onImageMiniPhotoClick(position: Int, image: String) {
                findNavController().popBackStack()
                //var newPositionInArrayImages: Int = position
                //newPositionInArrayImages++
                //navigateToFullScreenImage(storeProduct.storeProductId, newPositionInArrayImages)
            }
        }).also { binding.rvProduct.adapter = it }
    }
    private val onViewTapListenerTop = OnViewTapListener { view, x, y ->
        findNavController().popBackStack()
    }
}