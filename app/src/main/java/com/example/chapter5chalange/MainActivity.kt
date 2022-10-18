package com.example.chapter5chalange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.chapter5chalange.databinding.ActivityMainBinding
import com.example.chapter5chalange.adapter.AdapterViewPager
import com.example.chapter5chalange.ui.fragment1.Page1Fragment
import com.example.chapter5chalange.ui.fragment1.Page2Fragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val changeListnerViewpager = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Log.e("posisi", position.toString())
            binding.imageButton.isVisible = position == 1

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.viewPager.unregisterOnPageChangeCallback(changeListnerViewpager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFragment = mutableListOf(Page1Fragment(), Page2Fragment())
        val adapterViewPager = AdapterViewPager(this, listFragment)
        binding.viewPager.adapter = adapterViewPager
        binding.springDotsIndicator.attachTo(binding.viewPager)

        binding.viewPager.registerOnPageChangeCallback(changeListnerViewpager)

        binding.imageButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()

        }

    }
}