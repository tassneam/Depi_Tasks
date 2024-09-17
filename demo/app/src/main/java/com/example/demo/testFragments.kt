package com.example.demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.databinding.ActivityHomeBinding
import com.example.demo.databinding.ActivityTestFragmentsBinding

class testFragments : AppCompatActivity() {
    lateinit var binding: ActivityTestFragmentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

        }
    }
}