package com.tuncayavci.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    // launch scope in runBlocking scope
    // we can use coroutines inside other coroutines

    println("runBlocking start")
    runBlocking {
        println("   launch start")
        launch {
            delay(4000)
            println("   runBlocking launch")
        }
        println("   launch end")

        println("   coroutineScope start")
        coroutineScope {
            delay(2000)
            println("   coroutineScope")
        }
        println("   coroutineScope end")
    }
    println("runBlocking end")

    /* Logcat output :
    runBlocking start
       launch start
       launch end
       coroutineScope start
       coroutineScope
       coroutineScope end
       runBlocking launch
    runBlocking end
    */
}