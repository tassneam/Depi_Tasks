package com.example.demo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.databinding.ActivityHomeBinding
import com.example.demo.databinding.ActivityLoginBinding
import com.example.demo.databinding.ActivityStartBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var email= intent.getStringExtra("email")
        with(binding) {
//            searchview.setQueryHint("Artists, songs or podcasts");
            greetingTextView.text = "Welcome, $email"

        }
    }
}