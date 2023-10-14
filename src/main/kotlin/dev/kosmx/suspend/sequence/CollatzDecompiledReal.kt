package dev.kosmx.suspend.sequence

/**
 * This is a close to accurate decompiled version of [collatzGenerator]
 *
 * It can't be recompiled without direct JVM code manipulation
 * suspend functions aren't meant to be written by hand
 */

/*
import kotlin.coroutines.Continuation
class CollatzDecompiledReal(val continuation: Continuation<*>, val scope: SequenceScope<Int>, start: Int) {
    enum class State {
        ENTRY, CONTINUE
    }

    private var n: Int = start
    private var label = State.ENTRY

    fun getNextValue(): Any {
        while (true) {
            when (label) {
                State.ENTRY -> {
                    label = State.CONTINUE
                    if (scope.yield(n, this) == kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED) {
                        return kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
                    }
                }
                State.CONTINUE -> {
                    if (n % 2 == 0) {
                        n /= 2
                    } else {
                        n = 3 * n + 1
                    }
                    label = State.ENTRY
                }
            }
        }
    }
}//*/