package com.example.coroutines

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val job: Job = Job()
    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
//        lifecycleScope.launch {
//            var string = ""
//            var string2 = ""
//            val job = launch {
//                string = getString()
//            }
//            val job2 = launch {
//                string2 = getString2()
//            }
//            Log.i("test", string)
//            Log.i("test", string2)
//            job.join()
//            Log.i("test", string)
//            job2.join()
//            Log.i("test", string2)
//
//        }
//    }
//

//    private suspend fun getString(): String {
//        delay(1000)
//        return "test1"
//    }
//
//    private suspend fun getString2(): String {
//        delay(2000)
//        return "test2"
//    }


//        val job1 = coroutineScope.launch(Dispatchers.IO) {
//            for (i in 1..1000) {
//                delay(1000)
//                Log.i("test", "$i")
//            }
//        }
//        val job2 = coroutineScope.launch(Dispatchers.IO) {
//            for (i in 1..1000) {
//                delay(1000)
//                Log.i("test", "$i")
//            }
//        }
//        job.cancel()


        
        val channel = Channel<Int>()
        runBlocking {
            launch {
                for (i in 1..100)
                    channel.send(i)
            }
            launch {
                for (i in 1..100)
                    Log.i("test", "$i")
            }
        }
        lifecycleScope.launch {
            flow<Int> {
                for (i in 1..100)
                    emit(i)
            }.collect{
                Log.i("test",it.toString())
            }

        }
    }
}