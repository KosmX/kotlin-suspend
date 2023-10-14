package dev.kosmx.suspend.sequence


/**
 * It works as long as we don't want to invoke another suspend function from it
 */
class CollatzSequenceDecompiled(start: Int) {
    enum class State {
        ENTRY, CONTINUE
    }

    private var n: Int = start
    private var label = State.ENTRY

    fun getNextValue(): Int {
        while (true) {
            when (label) {
                State.ENTRY -> {
                    label = State.CONTINUE
                    return n
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
}