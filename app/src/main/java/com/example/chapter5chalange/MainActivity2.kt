package com.example.chapter5chalange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter5chalange.ui.fragment2.Page3aFragment

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val fragmentManager = supportFragmentManager
        val page3aFragment = Page3aFragment()
        val fragment = fragmentManager.findFragmentByTag(Page3aFragment::class.java.simpleName)
        if (fragment !is Page3aFragment) {
            fragmentManager.beginTransaction()
                .add(R.id.fm_2, page3aFragment, Page3aFragment::class.java.simpleName).commit()


        }

    }
}