package com.make.deve.pruebacoink.ui.registerFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.make.deve.pruebacoink.R
import com.make.deve.pruebacoink.databinding.FragmentUserNumberBinding
import com.make.deve.pruebacoink.databinding.LayoutPinCodeNumpadBinding
import com.make.deve.pruebacoink.ui.register.RegisterActivity

class UserPhoneFragment : Fragment() {

    lateinit var binding: FragmentUserNumberBinding

    private lateinit var viewModel: UserRegisterViewModel
    private lateinit var includeInternalLayout: LayoutPinCodeNumpadBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? RegisterActivity)?.toggleTitle(true, resources.getString(R.string.title_user_phone))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_user_number, container, false)

        viewModel = ViewModelProvider(this)
            .get(UserRegisterViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        includeInternalLayout = binding.numpad

        binding.numpad.checkBtn.isEnabled = false

        viewModel.newPhoneNumber.observe(viewLifecycleOwner){
            binding.maskedEditPhone.setText(it)
            if(it.length == 9){
                binding.numpad.checkBtn.isEnabled = true
                binding.numpad.checkBtn.isClickable = true
                binding.numpad.checkBtn.setImageResource(R.drawable.ic_check_circle_enabled_24)
            }else{
                binding.numpad.checkBtn.isEnabled = false
                binding.numpad.checkBtn.setImageResource(R.drawable.ic_check_circle_disabled_24)
            }
        }

        binding.numpad.checkBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Espera un momento...", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.nav_user_info)
        }



        return binding.root
    }

}