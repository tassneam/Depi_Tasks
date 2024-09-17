package com.example.dependencyinjectionretrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencyinjectionretrofit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var viewModel: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val albumAdapter = AlbumAdapter(mutableListOf())
        binding.albumList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = albumAdapter
        }
        viewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        viewModel.album.observe(this, Observer { albumList ->
            albumAdapter.updateData(albumList)
        })
    }
}
//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//    lateinit var binding:ActivityMainBinding
//    lateinit var viewModel: AlbumViewModel
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding=ActivityMainBinding.inflate(layoutInflater)
//        viewModel=ViewModelProvider(this).get(AlbumViewModel::class.java)
//        setContentView(binding.root)
//        viewModel.album.observe(this, Observer{
//            for (i in it){
//                Log.i("user",i.userId.toString())
//                Log.i("user",i.id.toString())
//                Log.i("user",i.title)
//
//            }
//        })
//    }
//}