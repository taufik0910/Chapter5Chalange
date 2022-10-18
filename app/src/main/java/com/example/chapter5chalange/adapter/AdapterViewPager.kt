package com.example.chapter5chalange.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterViewPager(fa: FragmentActivity, private val dataFragment: MutableList<Fragment>) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = dataFragment.size

    override fun createFragment(position: Int): Fragment = dataFragment[position]
}