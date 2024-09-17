package com.example.scoreapplication

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.scoreapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: ScoreViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.scoreTeamOne.observe(this, Observer {
            binding.score1.text = it.toString()
        })
        viewModel.scoreTeamTwo.observe(this, Observer {
            binding.score2.text = it.toString()
        })
        binding.increaseTeam1.setOnClickListener {
            viewModel.incrementTeamOneScore()
        }
        binding.increaseTeam2.setOnClickListener {
            viewModel.incrementTeamTwoScore()
        }

    }
}