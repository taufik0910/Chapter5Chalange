package com.example.chapter5chalange.ui.fragmantgame

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.chapter5chalange.R
import com.example.chapter5chalange.databinding.FragmentComBinding
import com.example.chapter5chalange.logic.LogicGame
import com.example.chapter5chalange.logic.ResultCallback


//
@Suppress("UNREACHABLE_CODE")
class ComFragment : Fragment(), ResultCallback {
    private lateinit var binding: FragmentComBinding

    companion object {
        const val EXSTRA_NAME = "extra name"
    }

    private var hasilPemainSatu = ""
    private var hasilPemainDua = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val name = arguments?.getString(EXSTRA_NAME)
            binding.txPemain.text = name

        }
        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
            .placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_foreground)
            .into(binding.imgLoad)

        val optuser = arrayOf(
            binding.usrBatu,
            binding.usrGunting,
            binding.usrKertas
        )

        val optLawan = arrayOf(
            binding.comBatu,
            binding.comGunting,
            binding.comKertas
        )

        val logicGame = LogicGame(this)
        optuser.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                hasilPemainSatu = optuser[index].contentDescription.toString()
                Toast.makeText(context, "${hasilPemainSatu.uppercase()}", Toast.LENGTH_SHORT).show()
                optuser.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                optuser[index].setBackgroundResource(R.drawable.bg_rounded)
            }
        }

        optLawan.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                hasilPemainDua = optLawan[index].contentDescription.toString()
                Toast.makeText(context, "${hasilPemainDua.uppercase()}", Toast.LENGTH_SHORT).show()
                optLawan.forEach { it.setBackgroundResource(android.R.color.transparent) }
                optLawan[index].setBackgroundResource(R.drawable.bg_rounded)

            }
        }


    }

    override fun result(hasil: String) {

    }




}

