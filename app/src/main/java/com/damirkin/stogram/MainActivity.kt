package com.damirkin.stogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

import com.damirkin.stogram.activities.RegisterActivity
import com.damirkin.stogram.databinding.ActivityMainBinding
import com.damirkin.stogram.ui.fragments.ChatsFragment
import com.damirkin.stogram.ui.objects.AppDrawer
import com.damirkin.stogram.utilits.replaceActivity
import com.damirkin.stogram.utilits.replaceFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()

    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
        mAuth = FirebaseAuth.getInstance()
    }

    private fun initFunc() {
        if (mAuth.currentUser!=null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment())
        } else {
            replaceActivity(RegisterActivity())
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

}