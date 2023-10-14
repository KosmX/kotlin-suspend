package dev.kosmx.suspend.sequence

private suspend fun SequenceScope<Int>.collatzGenerator(start: Int) {
    var n = start

    while (true) {
        yield(n)
        if (n % 2 == 0) {
            n /= 2
        } else {
            n = 3 * n + 1
        }
    }
}

// *magic*
fun collatzSequence(start: Int) = sequence { collatzGenerator(start) }


fun main() {
    //collatzSequence(1234).forEach(::println)

    val s = sequence {
        yield(1)
        yield(24)
        collatzGenerator(1234)
    }

    /**
     * See [kotlin.coroutines.jvm.internal.BaseContinuationImpl]
     */
    s.forEach { println(it) }
}
