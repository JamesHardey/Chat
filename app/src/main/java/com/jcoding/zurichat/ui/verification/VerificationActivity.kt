package com.jcoding.zurichat.ui.verification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jcoding.zurichat.ViewPagerAdapter
import com.jcoding.zurichat.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val viewPager = binding.viewPager

        val fragments = arrayListOf<Fragment>(
            VerificationFragmentOne(),
            VerificationFragmentTwo()
        )

        val adapter = ViewPagerAdapter(
            fragments,
            supportFragmentManager,
            lifecycle
        )

        //viewPager.adapter = adapter

    }
}