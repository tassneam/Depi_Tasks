package com.example.demo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.text.InputType
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            title.setText("Sign up")
            title.visibility = View.VISIBLE
            firstname.textEditText.hint = "First Name"
            lastname.textEditText.hint = "Last Name"
            editTextDOB.dateEditText.hint="DD/MM/YYYY"
            MobileNumber.numberEditText.hint="Mobile Number"
            Password.passwordEditText.hint="Password"
            email.textEditText.hint="Email"
            buttonRegister.setOnClickListener{
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d("MainActivity", "onCreate: ")

    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume: ")

    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause: ")

    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy: ")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart: ")

    }
}

