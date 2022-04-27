package com.make.deve.pruebacoink.ui.base

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.make.deve.pruebacoink.ui.register.RegisterViewModel
import com.make.deve.pruebacoink.ui.util.BaseUIDataError
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

abstract class BaseFragment: Fragment() {

    val TAG = "MAKE"

    protected val svm: RegisterViewModel by sharedViewModel()

    private val loadingObserver: Observer<Boolean> = Observer<Boolean> {
        svm.loading.value = it
    }

    fun observeLoading(loading: MutableLiveData<Boolean>) {
        loading.observe(viewLifecycleOwner, loadingObserver)
    }

    protected fun showErrorMessage(error: BaseUIDataError?) {
        error?.let {
            val dialog = AlertDialog.Builder(requireContext()).apply {
                setTitle(it.title)
                setMessage(it.message)
                setPositiveButton("Ok", null)
                setCancelable(false)
            }.create()
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        }
    }

}