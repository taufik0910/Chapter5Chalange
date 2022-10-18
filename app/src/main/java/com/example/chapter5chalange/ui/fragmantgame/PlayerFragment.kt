package com.example.chapter5chalange.ui.fragmantgame


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.chapter5chalange.R
import com.example.chapter5chalange.databinding.FragmentPlayerBinding



@Suppress("UNREACHABLE_CODE")
class PlayerFragment : Fragment() {
    companion object {
        const val EXSTRA_NAME = "extra name"

    }

    private lateinit var binding: FragmentPlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val name = arguments?.getString(ComFragment.EXSTRA_NAME)
            binding.txPemain.text = name


        }

        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
            .placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_foreground)
            .into(binding.imgLoad)

    }

}