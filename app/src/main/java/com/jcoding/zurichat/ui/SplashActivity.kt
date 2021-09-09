package com.jcoding.zurichat.ui

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.DisplayCutout
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.jcoding.zurichat.R
import com.jcoding.zurichat.databinding.ActivitySplashBinding
import com.jcoding.zurichat.ui.homepage.MainActivity
import com.jcoding.zurichat.ui.verification.VerificationActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeStatusBarTransparent()

        val image1 = binding.splashLogo
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        image1.setImageResource(R.drawable.splash_logo)
        image1.startAnimation(fadeInAnimation)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }

    private fun makeStatusBarTransparent(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            window.apply {

                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                    decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

                }
                else{
                    decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                }
                statusBarColor = Color.TRANSPARENT
            }
        }
    }


}