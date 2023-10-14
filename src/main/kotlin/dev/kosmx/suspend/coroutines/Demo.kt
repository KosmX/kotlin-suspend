package dev.kosmx.suspend.coroutines

import kotlinx.coroutines.*
import java.util.concurrent.Executors

fun main() {

    var i = 0

    val mainDispatcher = Executors.newSingleThreadExecutor {
        val t = Executors.defaultThreadFactory().newThread(it)
        t.setDaemon(true) // Set executor to daemon
        t
    }
        .asCoroutineDispatcher()

    runBlocking {
        CoroutineScope(Dispatchers.Unconfined).launch {

            // The program
            val code = suspend {
                coroutineScope {
                    val increment = withContext(Dispatchers.IO) {
                        // Calculate increment in a very inefficient way
                        //Thread.sleep(1000) // Thread.sleep suspends the platformThread, it's not efficient
                        delay(1000) // This only suspends the virtual thread, so other virtual threads can run
                        println("Calculation completed")
                        return@withContext 1 // return 1 :)
                    }

                    withContext(mainDispatcher) {
                        val x = i
                        Thread.sleep(10) // Make i += increment not atomic
                        //delay(10) // But be careful with suspend function call
                        i = x + increment
                    }
                }
            }

            for (iterator in 0 ..< 1000) { // Try to replace it with a larger number, see what happens
                launch {
                    code()
                }
            }
        }.join()
    }

    println("i is $i")

    println("Main ended here")
}

