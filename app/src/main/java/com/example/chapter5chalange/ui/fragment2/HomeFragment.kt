package com.example.chapter5chalange.ui.fragment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.example.chapter5chalange.MainActivity2
import com.example.chapter5chalange.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar


@Suppress("DEPRECATION")
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    companion object {
        val EXSTRA_NAME = "extra name"

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
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (arguments != null) {
            val name = arguments?.getString(EXSTRA_NAME)
            binding.tvName.text = "$name VS Pemain"
            binding.tvName2.text = "$name VS Com"



        }

    }
}


