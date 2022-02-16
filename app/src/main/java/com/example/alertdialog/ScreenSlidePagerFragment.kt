package com.example.alertdialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alertdialog.databinding.FragmentScreenSlideBinding


class ScreenSlidePagerFragment:Fragment() {
    lateinit var binding: FragmentScreenSlideBinding



    //private lateinit var viewPager: ViewPager2
    val image = arrayOf(
            "https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000",
            "https://24tv.ua/resources/photos/news/202010/1442017.jpg?1603454197000",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnIUzfCf4fQKF6Ugku9MQQoN9QsWBiESZBdg&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR19AQcA89PsDQB_n4P4s9T9K1p_nLlB-I5kQ&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnIUzfCf4fQKF6Ugku9MQQoN9QsWBiESZBdg&usqp=CAU"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentScreenSlideBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.pager.adapter = FitmamaAdapter(requireActivity(), image)
        binding.pager.post {
            binding.pager.setCurrentItem(2, true)
        }
        /*binding.clLayout.setOnTouchListener(object : OnTouchListenerPager(requireContext()) {

            override fun onSwipeDown() {
                super.onSwipeDown()
                Toast.makeText(requireContext(), "Swipe down gesture detected", Toast.LENGTH_SHORT)
                        .show()
                findNavController().popBackStack()
            }
        })*/
        /*binding.pager.setOnTouchListener(object : OnTouchListenerPager(requireContext()) {

            override fun onSwipeDown() {
                super.onSwipeDown()
                Toast.makeText(requireContext(), "Swipe down gesture detected", Toast.LENGTH_SHORT)
                        .show()
                findNavController().popBackStack()
            }
        })*/
    }

}