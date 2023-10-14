package dev.kosmx.suspend.extra

import kotlinx.coroutines.runBlocking

// simple code for decompiling
suspend fun testSuspend(i: Int): Int {
    return i * 2
}

fun main() {
    val it = path().iterator()
    val pos = it.next()
    println(pos)

    runBlocking {
        testSuspend(21)
    }


    path().take(1000).forEach {
        println(it)
    }

}