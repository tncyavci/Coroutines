package com.tuncayavci.coroutines

import kotlinx.coroutines.*

fun main() {

// Light  Weightness
//Coroutines are very efficient compared to Threads
//If we create many threads there will be an error or overloading the CPU
//so Coroutines make it easy

    //Scope
    //The structure that specifies where the created coroutine will be built
    // and in which lifecycle it will be included.

    //GlobalScope -> every class inside the app so GlobalScope is not widely used

    //runBlocking -> creates block for the scope
    //we can use when a single process is running a single coroutine

    //CoroutineScope -> is widely used

        GlobalScope.launch {
            //işlemin kaç kere yapılacağını göstermek için repeat() fonksiyonunu kullanıyoruz
            repeat(100000){
                //yine launch yaparak coroutines oluşturuyoruz
                launch {
                    println("Android")
                }
            }
        }


        println("runBlocking start")
        runBlocking {
            // launch{...} :coroutine başlatma kelimelerinden biridir yeni bir coroutine başlatır
            // içerisinde bulunduğumuz güncel thread ı bloklamaz
                launch {
                    // delay geciktirme işlemi sağlar internetten bir işlem yapıyoruz gibi simule ediyoruz
                    delay(2000)
                    println("runBlocking")
        }
    }
        // When we check with logcat, "runBlocking end" is written after runBlocking Scope is running
    println("runBlocking end")
    /* output :
    runBlocking start
    runBlocking
    runBlocking end
     */


        //GlobalScope ile aynı örneği yapıyoruz
     println("GlobalScope start")
     GlobalScope.launch {
        delay(5000)
        println("GlobalScope working")
     }
    println("GlobalScope end")
        /* output :
        GlobalScope start
        GlobalScope end
        GlobalScope working -- It continues the mainthread process because we did not use runBlocking.
        ----GlobalScope started when the delay time expired
         */



        /* CoroutineScope is used more
        We can also create it as coroutineScope{...}
        but we can use it either in coroutine or with suspend function. */

        /* The context must be the context of the Coroutine
        //Context shows which data it is run with
        //Context : Dispatchers. There 4 Different threads
        //We tell which coroutine to run
        //Default , Main, Unconfined, IO */

        println("CoroutineScope start")
        CoroutineScope(Dispatchers.Default).launch {
            delay(6000)
            println("CoroutineScope")
        }
        println("CoroutineScope end")
        //output :
        //CoroutineScope start
        //CoroutineScope end
        //CoroutineScope
        //CoroutineScope allows working in the desired thread

}