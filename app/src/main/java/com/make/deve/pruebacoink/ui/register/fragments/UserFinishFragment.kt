package com.make.deve.pruebacoink.ui.register.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.google.gson.Gson
import com.make.deve.pruebacoink.R
import com.make.deve.pruebacoink.databinding.FragmentUserFinishBinding
import com.make.deve.pruebacoink.ui.base.BaseFragment
import com.make.deve.pruebacoink.ui.register.RegisterActivity

class UserFinishFragment: BaseFragment() {

    lateinit var binding: FragmentUserFinishBinding
    val vm by navGraphViewModels<UserRegisterViewModel>(R.id.mobile_navigation)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? RegisterActivity)?.toggleTitle(true, resources.getString(R.string.title_user_finish),
            two = true,
            three = true
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_user_finish, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.acceptBtn.setOnClickListener { 
            verifyTerms()
        }

        binding.checkboxTerms.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                binding.acceptBtn.setTextColor(resources.getColor(R.color.darkGreen))
                binding.acceptBtn.backgroundTintList = resources.getColorStateList(R.color.green)
            }else{
                binding.acceptBtn.setTextColor(resources.getColor(R.color.white))
                binding.acceptBtn.backgroundTintList = resources.getColorStateList(R.color.gray)
            }
        }

        return binding.root
    }

    private fun verifyTerms(){
        if(!binding.checkboxTerms.isChecked){
            Toast.makeText(requireContext(), "Por favor, acepta el contrato", Toast.LENGTH_SHORT).show()
        }else{
            Log.d("UserResponse", "Data Json: ${Gson().toJson(vm.infoUserModel)}")
            findNavController().navigate(R.id.nav_success)
        }
    }

}