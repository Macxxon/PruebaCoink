package com.make.deve.pruebacoink.ui.util

import android.view.View

fun View.toggleVisibility(visib: Boolean) {
    visibility = if (visib) View.VISIBLE else View.GONE
}