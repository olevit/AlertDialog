package com.example.alertdialog

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alertdialog.databinding.FragmentFocusedBinding
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*


class FocusedFragment:Fragment() {
    lateinit var binding: FragmentFocusedBinding
    private val arrayListCountry = arrayListOf("Egypt", "Jordan", "Israel", "Lebanon")
    private val simplyDateFormat = SimpleDateFormat("MM/yy")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFocusedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemsCountry = listOf("Israel", "Turkey", "China")
        val adapterCountry = ArrayAdapter(requireContext(), R.layout.item_list, itemsCountry)
        (binding.country.editText as? AutoCompleteTextView)?.setAdapter(adapterCountry)
        (binding.country.editText as? AutoCompleteTextView)?.setOnItemClickListener(onItemClickListenerCountry)
        (binding.shippingVia.editText as? AutoCompleteTextView)?.setText("Israel", false)
        val itemsShipping = listOf("Pick Up Shop", "Door to Door", "Regular delivery")
        val adapterShipping = ArrayAdapter(requireContext(), R.layout.item_list, itemsShipping)
        (binding.shippingVia.editText as? AutoCompleteTextView)?.setAdapter(adapterShipping)

        val itemsCity = listOf("Haifa", "Rishon LeZion", "Ashdod")
        val adapterCity = ArrayAdapter(requireContext(), R.layout.item_list, itemsCity)
        (binding.city.editText as? AutoCompleteTextView)?.setAdapter(adapterCity)
        binding.email.editText?.setText("kkk")
        binding.email.editText?.addTextChangedListener(textWatcherEmail)
        binding.email.editText?.setOnFocusChangeListener(onFocusChangeListenerEmail)
        binding.firstName.editText?.addTextChangedListener(textWatcherFirstName)
        binding.firstName.editText?.setOnFocusChangeListener(onFocusChangeListenerFirstName)
        binding.lastName.editText?.addTextChangedListener(textWatcherLastName)
        binding.lastName.editText?.setOnFocusChangeListener(onFocusChangeListenerLastName)
        binding.streetName.editText?.addTextChangedListener(textWatcherStreetName)
        binding.streetName.editText?.setOnFocusChangeListener(onFocusChangeListenerStreetName)
        binding.postalCode.editText?.addTextChangedListener(textWatcherPostalCode)
        binding.postalCode.editText?.setOnFocusChangeListener(onFocusChangeListenerPostalCode)
        binding.phoneNumber.editText?.addTextChangedListener(textWatcherPhoneNumber)
        binding.phoneNumber.editText?.setOnFocusChangeListener(onFocusChangeListenerPhoneNumber)


        binding.title.setOnClickListener {
           // val dialog = MyDialogFragment()
           // dialog.show(requireActivity().supportFragmentManager, "NoticeDialogFragment")

        }


        binding.country.editText?.addTextChangedListener(textWatcherCountry)
        binding.country.editText?.setOnFocusChangeListener(onFocusChangeListenerCountry)
        binding.city.editText?.addTextChangedListener(textWatcherCity)
        binding.city.editText?.setOnFocusChangeListener(onFocusChangeListenerCity)
        binding.shippingVia.editText?.addTextChangedListener(textWatcherShippingVia)
        binding.shippingVia.editText?.setOnFocusChangeListener(onFocusChangeListenerShippingVia)




        binding.continueToPayment.setOnClickListener {
           // binding.title.text = binding.country.editText?.text.toString()
            if(binding.email.editText?.text!!.isNotEmpty() && binding.firstName.editText?.text!!.isNotEmpty()
                    && binding.lastName.editText?.text!!.isNotEmpty() && binding.streetName.editText?.text!!.isNotEmpty()
                    && binding.country.editText?.text!!.isNotEmpty() && binding.city.editText?.text!!.isNotEmpty()
                    && binding.postalCode.editText?.text!!.isNotEmpty() && binding.phoneNumber.editText?.text!!.isNotEmpty()
                    && binding.shippingVia.editText?.text!!.isNotEmpty() && binding.email.error == null
                    && binding.firstName.error == null && binding.lastName.error == null
                    && binding.streetName.error == null && binding.country.error == null
                    && binding.city.editText?.error == null && binding.postalCode.error == null
                    && binding.phoneNumber.error == null && binding.shippingVia.error == null){
                findNavController().popBackStack()
            }else{
                notValidateEmail(binding.email.editText?.text!!)
                //isEmptyLayout(binding.firstName.editText?.text!!, binding.firstName, "fffff")
                notValidateNames(binding.firstName.editText?.text!!, binding.firstName)
                notValidateNames(binding.lastName.editText?.text!!, binding.lastName)
                notValidateNames(binding.streetName.editText?.text!!, binding.streetName)
                notValidateNumbers(binding.country.editText?.text!!, binding.country)
                notValidateNumbers(binding.city.editText?.text!!, binding.city)
                notValidateNumbers(binding.phoneNumber.editText?.text!!, binding.phoneNumber)
                notValidateNumbers(binding.postalCode.editText?.text!!, binding.postalCode)
                notValidateNumbers(binding.shippingVia.editText?.text!!, binding.shippingVia)
                binding.title.text = (binding.shippingVia.editText as? AutoCompleteTextView)?.text

                //if(binding.postalCode.editText?.text!!.length == 5){
                   // binding.postalCode.error = "ok!"
                //}
            }
        }
        /*val simplyDateFormat = SimpleDateFormat("MM/yy")
        val simplyDateFormatDate = simplyDateFormat.parse("03/21")
        if (Date().after(simplyDateFormatDate)) {
            binding.title.text = "1"
        } else {
            binding.title.text ="0"
        }*/
    }
    private val onItemClickListenerCountry = AdapterView.OnItemClickListener { parent, view, position, id ->
        val item = parent!!.getItemAtPosition(position)
        if(item.equals(arrayListCountry[2]) || binding.country.editText?.text.toString().equals(arrayListCountry.get(2))){
            (binding.shippingVia.editText as? AutoCompleteTextView)?.setText("Regular delivery", false)
            val itemsShipping = listOf("Pick Up Shop", "Door to Door")
            val adapterShipping = ArrayAdapter(requireContext(), R.layout.item_list, itemsShipping)
            (binding.shippingVia.editText as? AutoCompleteTextView)?.setAdapter(adapterShipping)
        }
        else{
            (binding.shippingVia.editText as? AutoCompleteTextView)?.setText("Regular delivery", true)
            /*val itemsShipping = listOf("Regular delivery")
            val adapterShipping = ArrayAdapter(requireContext(), R.layout.item_list, itemsShipping)
            (binding.shippingVia.editText as? AutoCompleteTextView)?.setAdapter(adapterShipping)*/

        }
    }


    private val textWatcherEmail = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (Patterns.EMAIL_ADDRESS.matcher(s!!).matches()) {
                binding.email.error = null
            }
        }
    }

    private val textWatcherFirstName = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            validateNames(s!!, binding.firstName)
        }
    }

    private val textWatcherLastName = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
           validateNames(s!!, binding.lastName)
        }
    }
    private val textWatcherStreetName = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            validateNames(s!!, binding.streetName)
        }
    }
    private val textWatcherCountry = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            validateNumbers(s!!, binding.country)
        }
    }
    private val textWatcherCity = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            validateNumbers(s!!, binding.city)
        }
    }
    private val textWatcherPostalCode = object : TextWatcher {
        private var current = ""
        override fun afterTextChanged(s: Editable?) {
            if (s.toString() != current) {
                val userInput = s.toString().replace(Regex("[^\\d]"), "")
                if (userInput.length <= 4) {
                    current = userInput.chunked(2).joinToString("/")
                    s!!.filters = arrayOfNulls<InputFilter>(0)
                }
                s!!.replace(0, s.length, current, 0, current.length)
            }
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            validateNumbers(s!!, binding.postalCode)
            if (s.length > 5) {
                binding.postalCode.hint = "Zip"
            } else {
                binding.postalCode.hint = "Postal code"
            }
        }
    }
    private val textWatcherPhoneNumber = object : TextWatcher {
        private var current = ""
        override fun afterTextChanged(s: Editable?) {
            if (s.toString() != current) {
                val userInput = s.toString().replace(Regex("[^\\d]"), "")
                if (userInput.length <= 16) {
                    current = userInput.chunked(4).joinToString("-")
                    s!!.filters = arrayOfNulls<InputFilter>(0)
                }
                s!!.replace(0, s.length, current, 0, current.length)
            }
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            validateNumbers(s!!, binding.phoneNumber)
        }
    }
    private val textWatcherShippingVia = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            validateNumbers(s!!, binding.shippingVia)
        }
    }
    private val onFocusChangeListenerEmail = object : OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if (!hasFocus) {
                notValidateEmail((v as EditText).text)
            }
        }
    }
    private val onFocusChangeListenerFirstName = object : OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if (!hasFocus) {
                notValidateNames((v as EditText).text, binding.firstName)
            }
        }
    }
    private val onFocusChangeListenerLastName = object : OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if (!hasFocus) {
                notValidateNames((v as EditText).text, binding.lastName)
            }
        }
    }
    private val onFocusChangeListenerStreetName = object : OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if (!hasFocus) {
                notValidateNames((v as EditText).text, binding.streetName)
            }
        }
    }

    private val onFocusChangeListenerCountry = object : OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (!hasFocus) {
                    notValidateNumbers((v as EditText).text, binding.country)
                }
            }
    }
    private val onFocusChangeListenerCity = object : OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if (!hasFocus) {
                notValidateNumbers((v as EditText).text, binding.city)
            }
        }
    }
    private val onFocusChangeListenerPostalCode = object : OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if (!hasFocus) {
                notValidateNumbers((v as EditText).text, binding.postalCode)
            }
        }
    }
    private val onFocusChangeListenerPhoneNumber = object : OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if (!hasFocus) {
                notValidateNumbers((v as EditText).text, binding.phoneNumber)
            }
        }
    }
    private val onFocusChangeListenerShippingVia = object : OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if (!hasFocus) {
                notValidateNumbers((v as EditText).text, binding.shippingVia)
            }
        }
    }
    private fun notValidateEmail(s: CharSequence) {
        if(s.isEmpty()){
            binding.email.error = "This field is required"
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
            binding.email.error = "This email address is incorrect"
        }
        else {
            binding.email.error = null
        }
    }

    private fun notValidateNumbers(s: CharSequence, textInputLayout: TextInputLayout) {

        if (s.isEmpty()) {
            //binding.postalCode.error = "Postal code"
            textInputLayout.error = "This field is required"
        } else {
           // binding.postalCode.error = null
            textInputLayout.error = null
        }
        ///val simplyDateFormatDate = simplyDateFormat.parse(textInputLayout.editText?.text!!.toString())
        /*if (s.isEmpty()){
            textInputLayout.error = "This field is required"
        }
        else if(s.length != 5){
            textInputLayout.error = "Invalid date"
        }*/
        //val simplyDateFormat = SimpleDateFormat("MM/yy")
        //val simplyDateFormatDate = simplyDateFormat.parse(textInputLayout.editText?.text!!.toString())
        //val simplyDateFormat = SimpleDateFormat("MM/yy")
        //val simplyDateFormatDate = simplyDateFormat.parse("03/21")
        //if (Date().after(simplyDateFormatDate)) {
            //binding.title.text = "1"
       // } else {
           // binding.title.text ="0"
        //}



       /* else if(s.length == 5 && Date().after(simplyDateFormat.parse(textInputLayout.editText?.text!!.toString())))
        {
            textInputLayout.error = "Invalid date"
        }
        else{
            textInputLayout.error = null

        }*/
    }

    private fun notValidateNames(s: CharSequence, textInputLayout: TextInputLayout) {
        if (s.isEmpty()){
            textInputLayout.error = "This field is required"
        }
        else if (s.length == 1){
           // if(textInputLayout.editText?.text!!.contains(" ")) {
            //binding.firstName.error = "Last name"
            textInputLayout.error = "Minimum of 2 letters"

        } else if(s.length == 2 && textInputLayout.editText?.text!!.contains(" ")){
            textInputLayout.error = "Minimum of 2 letters"
        }

        else {
           // binding.firstName.error = null
            textInputLayout.error = null
        }
    }
    private fun validateNames(s: CharSequence, textInputLayout: TextInputLayout) {
        if(s.length == 2 && !textInputLayout.editText?.text!!.contains(" ")){
            textInputLayout.error = null
        }
        else if(s.length > 2){
            textInputLayout.error = null
        }
    }
    private fun validateNumbers(s: CharSequence, textInputLayout: TextInputLayout) {

        if (s.isNotEmpty()) {
            textInputLayout.error = null
        }
        //val simplyDateFormat = SimpleDateFormat("MM/yy")
        //val simplyDateFormatDate = simplyDateFormat.parse(textInputLayout.editText?.text!!.toString())

        /*if (s.length == 5 && Date().before(simplyDateFormat.parse(textInputLayout.editText?.text!!.toString())))
        {
            textInputLayout.error = null
        }*/
    }
}




