package com.example.fansettechinician

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fansettechinician.service.DataModel.Destination
import com.example.fansettechinician.service.DestinationService
import com.example.fansettechinician.service.ServiceBuilder
import kotlinx.android.synthetic.main.activity_splash_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        SplashImage.alpha = 0f
        SplashImage.animate().setDuration(1500).alpha(1f).withEndAction {
            var i = Intent(this, JobCardActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }



    }




}
