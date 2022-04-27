package com.make.deve.pruebacoink.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import com.make.deve.pruebacoink.R
import com.make.deve.pruebacoink.databinding.ActivityMainBinding
import com.make.deve.pruebacoink.ui.register.RegisterActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.registerBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
        }
    }
}