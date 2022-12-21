package com.tuncayavci.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    //suspend function : are functions that can be run in a coroutine
    //what it does : suspendable we can stop and continue whenever we want


    runBlocking {
        delay(2000)
        println("runBlocking")
        myFunction()
    }
}
suspend fun myFunction() {

    coroutineScope {
        delay(4000)
        println("suspend function")
    }
}