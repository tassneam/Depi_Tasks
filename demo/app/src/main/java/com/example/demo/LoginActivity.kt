package com.example.demo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            title.setText("Login")
            title.visibility = View.VISIBLE
            Email.textEditText.hint = "Email"
            Password.passwordEditText.hint = "Password"
            buttonLogin.setOnClickListener{
                val intent = Intent(applicationContext, HomeActivity::class.java)
                intent.putExtra("email",Email.textEditText.text.toString())
                startActivity(intent)
            }
        }
    }
}