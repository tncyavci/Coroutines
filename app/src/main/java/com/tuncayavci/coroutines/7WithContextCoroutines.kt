package com.tuncayavci.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {

    //withContext
    // It is used to switch from one thread to another.
    //so we can do operations in different threads within the same scope
    //In general, We'll see it starting with Dispatchers.IO and continuing with Dispatchers.Thread
    //with Retrofit

    runBlocking {
        launch(Dispatchers.Default){
            println("Context : ${coroutineContext}")
            withContext(Dispatchers.IO) {
                println("Context : ${coroutineContext}")
            }
        }
    }
}