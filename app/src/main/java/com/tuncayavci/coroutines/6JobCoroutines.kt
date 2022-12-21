package com.tuncayavci.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    //Job : we can check the returned jobs later

    runBlocking {
        val myJob = launch {
            delay(2000)
            println("job")

            val secondJob= launch {
                println("job 2")
            }
        }


        myJob.invokeOnCompletion {
            println("myJob end")
        }

        myJob.cancel() // when job is canceled, their process stop also their inner process stop
        //in Fragment -- onClear() method
        //in Activity -- onDestroy() method coroutines are closed

        // before myJob.cancel() output :
        //job
        //job 2
        //myJob end

        // with myJob.cancel() output :
        //myJob end

    }
}