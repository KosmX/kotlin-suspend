package dev.kosmx.suspend.stack

/**
 * Collatz conjecture
 * [Collatz](https://wikimedia.org/api/rest_v1/media/math/render/svg/9b2a03faf9d31a8de0abb3c4a3d318490105da12)
 */
private fun collatz(start: Int) {
    var n = start

    while (true) {
        printNumber(n)
        if (n <= 1) return // This may never exit...
        if (n % 2 == 0) {
            n /= 2
        } else {
            n = 3 * n + 1
        }
    }
}

// This is completely unnecessary, just showcasing some callstack
fun printNumber(int: Int) {
    val str = int.toString()
    println(str)
}


fun main() {
    collatz(39018571)
}

