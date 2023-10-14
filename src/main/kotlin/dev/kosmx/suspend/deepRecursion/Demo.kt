package dev.kosmx.suspend.deepRecursion

private var depth = 0

fun recursion() {
    depth++
    recursion()
}


val deepRecursion = DeepRecursiveFunction {
    if (depth == 1_000_000) {
        println("Reached $depth depth")
        // Well, after 1M depth, I can not debug it because the call-stack is just too big
        return@DeepRecursiveFunction
    }
    depth++
    callRecursive(Unit)
}

fun main() {
    depth = 0
    try {
        recursion()
    } catch (_: StackOverflowError) {
        println("depth reached is $depth")
    }

    depth = 0
    deepRecursion(Unit) // It will take almost forever

}