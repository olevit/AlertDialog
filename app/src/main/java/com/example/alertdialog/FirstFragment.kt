package com.example.alertdialog

import android.location.LocationProvider
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alertdialog.databinding.FragmentFirstBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    //lateinit var listProgram: ArrayList<ProgramData>
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.imageView1.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
        binding.imageView.setOnClickListener {
            if(binding.counter.text.toString().toInt() == 0 ){
                val dialog = MyDialogFragment()
                dialog.show(requireActivity().supportFragmentManager, "NoticeDialogFragment")
            }
            else {
                findNavController().navigate(R.id.secondFragment)
            }
        }
        binding.imageView2.setOnClickListener {
           findNavController().navigate(R.id.chipFragment)
        }
       // binding.counter.setOnClickListener {
           // findNavController().navigate(R.id.action_firstFragment_to_bigPhotoFragment)}
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val locale : String = requireContext().resources.configuration.locale.country.toString()
        //val locale : String = requireContext().resources.configuration.locale.displayCountry.toString()
        var local = "Israel"
        binding.counter.setOnClickListener {
            findNavController().navigate(R.id.screenFragment)
        }
//need list of countries, where we can shipping
        val arrayListShipping = arrayListOf("Egypt", "Jordan", "Israel","Lebanon")
// need to detect the user’s country via his IP address
        arrayListShipping.add(0, local)//add user`s country to spinnerShipping
// in the first position
        val arrayAdapterShipping = ArrayAdapter(requireContext(), R.layout.item_list,
                arrayListShipping)
        binding.spinnerShipping.adapter = arrayAdapterShipping
        binding.spinnerShipping.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (binding.spinnerShipping.selectedItem.equals(local)){
                    binding.tvUpTo.text = "Up to 7 business days"
                    val arrayListPickUpShop = arrayListOf("Pick up shop","Door to Door")
                    val arrayAdapterPickUpShop = ArrayAdapter(requireContext(), R.layout.item_list, arrayListPickUpShop)
                    binding.spinnerPickUpShop.adapter = arrayAdapterPickUpShop
                    //need price shipping "Door to Door"
                    if(binding.spinnerPickUpShop.selectedItemPosition == 0){
                        binding.tvPriceShipping.text = "$ 35.00"
                    }
                } else{
                    //need price shipping in other country
                    val arrayListPickUpShop = arrayListOf("Regular delivery")
                    val arrayAdapterPickUpShop = ArrayAdapter(requireContext(), R.layout.item_list, arrayListPickUpShop)
                    binding.spinnerPickUpShop.adapter = arrayAdapterPickUpShop
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}}



            binding.imageView3.setOnClickListener {
            val budle = bundleOf("country" to binding.spinnerShipping.selectedItem.toString(),
                    "shipping" to binding.spinnerPickUpShop.selectedItem.toString(),
                    "priceshipping" to binding.tvPriceShipping.text.toString())
            findNavController().navigate(R.id.orderFragment, budle)

        }
        binding.cl.setOnTouchListener(object : OnTouchListenerPager(requireContext()) {
            /*override fun onSwipeLeft() {
                super.onSwipeLeft()
                Toast.makeText(requireContext(), "Swipe Left gesture detected",
                        Toast.LENGTH_SHORT)
                        .show()
            }
            override fun onSwipeRight() {
                super.onSwipeRight()
                Toast.makeText(
                        requireContext(),
                        "Swipe Right gesture detected",
                        Toast.LENGTH_SHORT
                ).show()
            }
            override fun onSwipeUp() {
                super.onSwipeUp()
                Toast.makeText(requireContext(), "Swipe up gesture detected", Toast.LENGTH_SHORT)
                        .show()
            }*/
            override fun onSwipeDown() {
                super.onSwipeDown()
                Toast.makeText(requireContext(), "Swipe down gesture detected", Toast.LENGTH_SHORT)
                        .show()
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            }
        })
    }
}