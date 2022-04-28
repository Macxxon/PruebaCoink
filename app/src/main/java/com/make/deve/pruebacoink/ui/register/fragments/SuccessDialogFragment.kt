package com.make.deve.pruebacoink.ui.register.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.make.deve.pruebacoink.databinding.FragmentSuccessBinding
import com.make.deve.pruebacoink.ui.base.BaseDialogFragment

class SuccessDialogFragment : BaseDialogFragment() {
    override val width: Int
        get() = ViewGroup.LayoutParams.MATCH_PARENT
    override val height: Int
        get() = ViewGroup.LayoutParams.WRAP_CONTENT

    lateinit var binding: FragmentSuccessBinding


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(requireContext(), theme) {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuccessBinding.inflate(inflater, container, false)
        binding.successBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Exitoso!", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}