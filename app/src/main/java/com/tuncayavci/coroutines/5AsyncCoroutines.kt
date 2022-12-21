package com.tuncayavci.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    //Async
    // for example we download two data from internet,
    // one is name and the other is age
    //When we say async, it actually expects a response from us.

    var username = ""
    var userage = 0
/*
    runBlocking {
        launch {
            val downloadedName = downloadName()
            username = downloadedName

        }
       launch {
           val downloadedAge = downloadAge()
           userage = downloadedAge
       }
        println("${username} ${userage}")

        // output :
        // 0
        //username download
        //userage download
        //Doesn't show downloaded data as there is no concept of async
    }

 */

    runBlocking {
            val downloadedName = async {
                downloadName()
            }
            val downloadedAge = async {
                downloadAge()
            }
        username = downloadedName.await()
        userage = downloadedAge.await()

        println("${username} ${userage}")
        //output:
        //username download
        //userage download
        //John : 25

        }


}

suspend fun downloadName() : String {
    delay(2000) //We think of delay as a download time for simulation purposes.
    val userName = "John :"
    println("username download")
    return userName
}

suspend fun downloadAge() : Int{
    delay(3000)
    val userAge = 25
    println("userage download")
    return userAge
}