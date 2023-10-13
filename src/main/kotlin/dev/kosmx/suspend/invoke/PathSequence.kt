package dev.kosmx.suspend.invoke

import kotlin.coroutines.Continuation

/**
 * [kotlin.coroutines.jvm.internal.BaseContinuationImpl]
 */
class PathSequence : /*kotlin.coroutines.jvm.internal.RestrictedSuspendLambda*/ () -> PathSequence {

    private var label: Int = 0
    private lateinit var scope: Continuation<Pos>

    private var pos = Pos()
    private var length = 1

    private var iter = 0

    fun invokeSuspend(): Pos {
        when(label) { // Kotlin switch-case
            0 -> {
                iter = 0
                label = 1
                return pos
            }
            1 -> {
                pos += Pos(1, 0)
                iter++
                if (iter >= length) {
                    iter = 0
                    label = 2
                }
                return pos
            }
            2 -> {
                pos += Pos(0, 1)
                iter++
                if (iter >= length) {
                    length++
                    iter = 0
                    label = 3
                }
                return pos
            }
            3 -> {
                pos -= Pos(1, 0)
                iter++
                if (iter >= length) {
                    iter = 0
                    label = 4
                }
                return pos
            }
            4 -> {
                pos -= Pos(0, 1)
                iter++
                if (iter >= length) {
                    length++
                    iter = 0
                    label = 1
                }
                return pos
            }

            else -> error("invalid state")
        }
    }


    override fun invoke(): PathSequence {
        return PathSequence()
    }

}