package com.make.deve.pruebacoink.ui.registerFragments

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.make.deve.pruebacoink.R
import com.make.deve.pruebacoink.databinding.FragmentUserInfoBinding
import com.make.deve.pruebacoink.ui.register.RegisterActivity
import com.make.deve.pruebacoink.ui.base.BaseFragment

class UserInfoFragment: BaseFragment() {

    lateinit var binding: FragmentUserInfoBinding
    val vm:UserRegisterViewModel by viewModels()

    private lateinit var viewModel: UserRegisterViewModel
    private var documentNumber: String? = null
    private var email: String? = null
    private var emailConfirm: String? = null
    private var pinCode: String? = null
    private var pinCodeConfirm: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? RegisterActivity)?.toggleTitle(true, resources.getString(R.string.title_user_info))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_user_info, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        observeLoading(vm.loading)
        vm.listofDocTypes.observe(viewLifecycleOwner) {
            it?.let {
                if (it.error == null) {
                    val docTypesAdapter = ArrayAdapter(requireContext(), R.layout.list_item, it.items.map { x->x.description })
                    binding.documentType.setAdapter(docTypesAdapter)
                }else{
                    showErrorMessage(it.error)
                }
            }
        }

        vm.listofGenders.observe(viewLifecycleOwner) {
            it?.let {
                if (it.error == null) {
                    val genderAdapter = ArrayAdapter(requireContext(), R.layout.list_item, it.items.map { x->x.name })
                    binding.gender.setAdapter(genderAdapter)
                }else{
                    showErrorMessage(it.error)
                }
            }
        }

        vm.getDocTypes()
        vm.getGenders()

        binding.nextBtn.setOnClickListener {
            attemptRegister()
        }

        return binding.root
    }

    private fun isEmailValid(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun isPinValid(pin: String): Boolean {
        return pin.length == 4
    }

    private fun attemptRegister() {
        // Reset errors.
        binding.documentNumber.error = null
        binding.email.error = null
        binding.emailConfirm.error = null
        binding.pinCode.error = null
        binding.pinCodeConfirm.error = null

        documentNumber = binding.documentNumber.text.toString()
        email = binding.email.text.toString()
        emailConfirm = binding.emailConfirm.text.toString()
        pinCode = binding.pinCode.text.toString()
        pinCodeConfirm = binding.pinCodeConfirm.text.toString()
        var cancel = false
        var focusView: View? = null

        if (TextUtils.isEmpty(documentNumber.toString())) {
            binding.documentNumber.error = getString(R.string.error_field_required)
            focusView = binding.documentNumber
            cancel = true
        } else if (!isEmailValid(email!!)) {
            binding.email.error = getString(R.string.error_invalid_email)
            focusView = binding.email
            cancel = true
        } else if (TextUtils.isEmpty(pinCode)) {
            binding.pinCode.error = getString(R.string.error_field_required)
            focusView = binding.pinCode
            cancel = true
        }
        if (!TextUtils.isEmpty(pinCode) && !isPinValid(pinCode!!)) {
            binding.pinCode.error = getString(R.string.error_pin_code)
            focusView = binding.pinCode
            cancel = true
        }
        if (cancel) {
            focusView!!.requestFocus()
        } else {


        }
    }

}