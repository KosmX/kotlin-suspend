package dev.kosmx.suspend.invoke

import kotlinx.coroutines.runBlocking

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