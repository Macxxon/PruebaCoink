package com.make.deve.pruebacoink.ui.util

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val loading = MutableLiveData(false)
}