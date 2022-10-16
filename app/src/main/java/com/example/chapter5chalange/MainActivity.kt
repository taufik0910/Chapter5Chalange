package com.example.chapter5chalange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.chapter5chalange.databinding.ActivityMainBinding
import com.example.chapter5chalange.databinding.ActivitySplashBinding
import com.example.chapter5chalange.ui.fragment.AdapterViewPager
import com.example.chapter5chalange.ui.fragment.Page1Fragment
import com.example.chapter5chalange.ui.fragment.Page2Fragment
import com.example.chapter5chalange.ui.fragment.Page3aFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val changeListnerViewpager = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Log.e("posisi", position.toString())
            if (position == 1) {
                binding.imageButton.isVisible = true
            } else {
                binding.imageButton.isVisible = false
            }

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

        val listFragment = mutableListOf(Page1Fragment(), Page2Fragment(), Page3aFragment())
        val adapterViewPager = AdapterViewPager(this, listFragment)
        binding.viewPager.adapter = adapterViewPager
        binding.springDotsIndicator.attachTo(binding.viewPager)

        binding.viewPager.registerOnPageChangeCallback(changeListnerViewpager)

        binding.imageButton.setOnClickListener {
            val currentPosition = binding.viewPager.currentItem
            binding.viewPager.setCurrentItem(currentPosition + 1)
        }

    }
}