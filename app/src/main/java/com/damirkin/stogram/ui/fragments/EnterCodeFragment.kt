package com.damirkin.stogram.ui.fragments

import androidx.fragment.app.Fragment
import com.damirkin.stogram.R
import com.damirkin.stogram.utilits.AppTextWatcher
import com.damirkin.stogram.utilits.showToast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment(val phoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {

    private lateinit var mAuth: FirebaseAuth


    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                verificateCode()
            }
        })
    }

    fun verificateCode() {
        showToast("Yes")

    }

}