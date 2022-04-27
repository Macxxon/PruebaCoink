package com.make.deve.pruebacoink.resources

import androidx.annotation.IntegerRes
import com.make.deve.pruebacoink.App

object Integers {
    fun get(@IntegerRes stringRes: Int): Int {
        return App.instance.resources.getInteger(stringRes)
    }
}