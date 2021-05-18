package com.damirkin.stogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.damirkin.stogram.databinding.ActivityMainBinding
import com.damirkin.stogram.ui.fragments.ChatsFragment
import com.damirkin.stogram.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar

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
        mAppDrawer.create()
        mAppDrawer = AppDrawer(this, mToolbar)
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,
                ChatsFragment()
            ).commit()
    }

}