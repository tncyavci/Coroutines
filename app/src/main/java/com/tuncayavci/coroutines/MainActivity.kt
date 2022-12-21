package com.tuncayavci.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //3DispatcherCoroutines.kt code block
        //this block don't run in 3DispatcherCoroutines.kt because of MainThread
        runBlocking {
            launch(Dispatchers.Main) {
                println("Main Thread : ${Thread.currentThread().name}")
            }

            launch(Dispatchers.IO){
                println("Io Thread : ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) {
                println("Default Thread : ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Unconfined) {
                println("Unconfined thread : ${Thread.currentThread().name}")
            }
        }
        /*output :
        Io Thread : DefaultDispatcher-worker-1
        Default Thread : DefaultDispatcher-worker-3
        Unconfined thread : main
        */


    }
}