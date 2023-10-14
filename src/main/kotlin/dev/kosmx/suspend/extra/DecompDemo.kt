package dev.kosmx.suspend.extra

fun main() {

    val sequence = PathSequence()

    for (i in 0..<1000) {
        val pos = sequence.invokeSuspend()
        println(pos)
    }
}