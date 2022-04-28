package com.make.deve.pruebacoink.ui.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment() {

    abstract val width: Int
    abstract val height: Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.run {
            setCanceledOnTouchOutside(false)
            setCancelable(false)
        }

    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.run {
            setLayout(
                if (width == ViewGroup.LayoutParams.MATCH_PARENT || width == ViewGroup.LayoutParams.WRAP_CONTENT) width else
                    ViewGroup.LayoutParams.MATCH_PARENT,
                if (height == ViewGroup.LayoutParams.MATCH_PARENT || height == ViewGroup.LayoutParams.WRAP_CONTENT) height else
                    ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

}