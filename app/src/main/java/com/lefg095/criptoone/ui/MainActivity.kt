package com.lefg095.criptoone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lefg095.criptoone.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    //supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

}