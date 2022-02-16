package com.example.alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.alertdialog.databinding.FragmentFocusedBinding
import com.example.alertdialog.databinding.FragmentOrderBinding
import java.util.*

class OrderFragment:Fragment() {
    lateinit var binding: FragmentOrderBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOrderBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val country = requireArguments().getString("country")
        val shipping = requireArguments().getString("shipping")
        val shippingPrice = requireArguments().getString("priceshipping")
        val itemsCountry = listOf("Israel", "Turkey", "China")
        (binding.shippingVia.editText as? AutoCompleteTextView)?.setText(shipping + " " + shippingPrice, true)//spinner work, because spinner adapter add second
        val adapterCountry = ArrayAdapter(requireContext(), R.layout.item_list, itemsCountry)
        (binding.country.editText as? AutoCompleteTextView)?.setAdapter(adapterCountry)
        (binding.country.editText as? AutoCompleteTextView)?.setText(country, false)//true sinner do not work, false + work spinner

    }
    


}