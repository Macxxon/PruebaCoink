package com.make.deve.pruebacoink.ui.register

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.make.deve.pruebacoink.R
import com.make.deve.pruebacoink.databinding.ActivityRegisterBinding
import com.make.deve.pruebacoink.ui.main.MainViewModel
import com.make.deve.pruebacoink.ui.util.toggleVisibility
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    val vm: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        vm.loading.observe(this) {
            binding.loadingLy.visibility = if (it) View.VISIBLE else View.GONE
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    fun toggleTitle(showTitle: Boolean, title:String, two:Boolean, three:Boolean) {
        binding.topView.toggleVisibility(showTitle)
        binding.titleTxt.text = title
        if(two){
            binding.twoProgress.setImageResource(R.drawable.ic_baseline_circle_green_24)
        }else{
            binding.twoProgress.setImageResource(R.drawable.ic_baseline_circle_24)
        }
        if(three){
            binding.threeProgress.setImageResource(R.drawable.ic_baseline_circle_green_24)
        }else{
            binding.threeProgress.setImageResource(R.drawable.ic_baseline_circle_24)
        }

    }
}