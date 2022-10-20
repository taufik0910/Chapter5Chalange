package com.example.chapter5chalange.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.chapter5chalange.R


class DialogResultFragment : DialogFragment() {
    lateinit var btnMainLagi: Button
    lateinit var btnback: Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_dialog_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMainLagi = view.findViewById(R.id.btn_main_lagi)
        btnback.setOnClickListener {  }
    }

    interface OnOptionDialogListener{
        fun onOptionChoose(text:String?)
    }


}