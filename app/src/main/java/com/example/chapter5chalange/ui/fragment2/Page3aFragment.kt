package com.example.chapter5chalange.ui.fragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chapter5chalange.R
import com.example.chapter5chalange.databinding.FragmentPage3aBinding
import com.google.android.material.snackbar.Snackbar


class Page3aFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentPage3aBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPage3aBinding.inflate(inflater, container, false)
        return binding.root
    }

    //    method tidak berfungsi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPg3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_pg3) {
            val homeFragment = HomeFragment()
            val fragmentManager = parentFragmentManager

            val bundle = Bundle()
            val value = binding.etName.text.toString()
            bundle.putString(HomeFragment.EXSTRA_NAME, value)
            homeFragment.arguments = bundle

            fragmentManager.beginTransaction().apply {
                replace(R.id.fm_2, homeFragment, HomeFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }

        }
    }


}


