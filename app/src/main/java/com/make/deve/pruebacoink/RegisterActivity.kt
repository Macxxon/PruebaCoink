package com.make.deve.pruebacoink

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.make.deve.pruebacoink.databinding.ActivityMainBinding
import com.make.deve.pruebacoink.databinding.ActivityRegisterBinding
import com.make.deve.pruebacoink.util.toggleVisibility

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    fun toggleTitle(showTitle: Boolean, title:String) {
        binding.topView.toggleVisibility(showTitle)
        binding.titleTxt.text = title
    }
}