package dev.kosmx.suspend.sequence

fun main() {
    // val numbers = collatzSequence(n)
    val numbers = CollatzSequenceDecompiled(12345)

    //number.takeWhile { it != 1 }.forEach(::println)

    while (true) {
        val next = numbers.getNextValue()
        if (next == 1) break

        println(next)
    }
}