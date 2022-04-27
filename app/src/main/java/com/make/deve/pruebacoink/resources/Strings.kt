package com.make.deve.pruebacoink.resources

import androidx.annotation.StringRes
import com.make.deve.pruebacoink.App

object Strings {

    fun get(@StringRes stringRes: Int, vararg formatArgs: Any = emptyArray()): String {
        return App.instance.getString(stringRes, *formatArgs)
    }
}