package com.make.deve.pruebacoink.registerFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.make.deve.pruebacoink.R
import com.make.deve.pruebacoink.RegisterActivity
import com.make.deve.pruebacoink.databinding.FragmentUserNumberBinding

class UserNumberFragment : Fragment() {

    lateinit var binding: FragmentUserNumberBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? RegisterActivity)?.toggleTitle(true, resources.getString(R.string.title_user_number))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_user_number, container, false)



        return binding.root
    }

}