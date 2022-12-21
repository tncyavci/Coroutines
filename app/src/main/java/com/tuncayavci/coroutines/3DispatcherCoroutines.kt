package com.tuncayavci.coroutines

fun main() {

    //Dispatcher : We specify which thread to work with using Dispatchers
    // Default, Main, IO, Unconfined
    //Default CPU insentive , visual operations or sorting too much data
    //IO -> networking process ,
    //Main -> UI process
    //Unconfined -> (InheritedDispatcher)

    /*
        Since we are running Main thread in this code, runBlocking will not work here,
    so we will try by running the same code in MainActivity.

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

     */
}