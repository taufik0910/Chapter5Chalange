package com.example.chapter5chalange.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Parcel
import android.os.Parcelable
import com.bumptech.glide.Glide
import com.example.chapter5chalange.MainActivity
import com.example.chapter5chalange.R
import com.example.chapter5chalange.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity(), Parcelable {
    private lateinit var binding: ActivitySplashBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
            .placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_foreground)
            .into(binding.imgLoad)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3500)

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SplashActivity> {
        override fun createFromParcel(parcel: Parcel): SplashActivity {
            return SplashActivity()
        }

        override fun newArray(size: Int): Array<SplashActivity?> {
            return arrayOfNulls(size)
        }
    }
}