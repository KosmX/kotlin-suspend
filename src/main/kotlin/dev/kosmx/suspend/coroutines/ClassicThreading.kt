package dev.kosmx.suspend.coroutines

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.Future

fun main() {

    var i = 0

    val mainDispatcher = Executors.newSingleThreadExecutor {
        val t = Executors.defaultThreadFactory().newThread(it)
        t.setDaemon(true)
        t
    }

    val ioDispatcher = Executors.newFixedThreadPool(64) {
        val t = Executors.defaultThreadFactory().newThread(it)
        t.setDaemon(true)
        t
    }


    val program: () -> Future<Unit> = {

        val future = CompletableFuture<Unit>()

        ioDispatcher.execute {

            // Calculate increment in a very inefficient way
            Thread.sleep(1000)
            println("Calculation completed")
            val increment = 1

            mainDispatcher.execute {

                val x = i
                Thread.sleep(10) // Make i += increment not atomic
                //delay(10) // But be careful with suspend function call
                i = x + increment
                future.complete(Unit)
            }
        }

        future
    }

    val tasks = (0 ..< 100).map { program() }
    tasks.forEach { it.get() } // awaitAll

    println("i is $i")
}
