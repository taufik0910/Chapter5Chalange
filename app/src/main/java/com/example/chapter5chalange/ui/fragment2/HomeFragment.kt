@file:Suppress("UNREACHABLE_CODE")

package com.example.chapter5chalange.ui.fragment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chapter5chalange.R
import com.example.chapter5chalange.databinding.FragmentHomeBinding
import com.example.chapter5chalange.ui.fragmantgame.ComFragment
import com.example.chapter5chalange.ui.fragmantgame.PlayerFragment
import com.google.android.material.snackbar.Snackbar


@Suppress("DEPRECATION")
class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding

    companion object {
        const val EXSTRA_NAME = "extra name"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    @SuppressLint("SetTextI18n")
    @Deprecated("Deprecated in Java")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val name = arguments?.getString(EXSTRA_NAME)
            binding.tvName.text = "$name VS Pemain"
            binding.tvName2.text = "$name VS Com"
            binding.tvHide.text = name
            Snackbar.make(view, "SELAMAT DATANG $name ", Snackbar.LENGTH_SHORT)
                .setAction("tutup") {}.show()

        }
        binding.imgImage1.setOnClickListener(this)
        binding.imgImage2.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val comFragment = ComFragment()
        val playerFragment = PlayerFragment()
        val bundle = Bundle()
        val value = binding.tvHide.text.toString()
        val fragmentManager = parentFragmentManager
        if (v?.id == R.id.img_image2) {
            bundle.putString(ComFragment.EXSTRA_NAME, value)
            comFragment.arguments = bundle
            fragmentManager.beginTransaction().apply {
                replace(R.id.fm_2, comFragment, ComFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
        if (v?.id == R.id.img_image1) {
            bundle.putString(PlayerFragment.EXSTRA_NAME, value)
            playerFragment.arguments = bundle

            fragmentManager.beginTransaction().apply {
                replace(R.id.fm_2, playerFragment, PlayerFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

    }
}


