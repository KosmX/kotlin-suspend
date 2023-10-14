package dev.kosmx.suspend.extra

data class Pos(val x: Int = 0, val y: Int = 0) {
    operator fun plus(other: Pos) = Pos(x + other.x, y + other.y)
    operator fun unaryMinus() = Pos(-x, -y)
    operator fun minus(pos: Pos) = Pos(x - pos.x, y - pos.y)
}

fun path() = sequence {
    var pos = Pos() // label 0

    var length = 1

    while (true) {
        // increase X
        for (i in 0..<length) {
            yield(pos) // label 1
            pos += Pos(1, 0)
        }

        // increase Y
        for (i in 0..<length) {
            yield(pos)
            pos += Pos(0, 1)
        }
        length++

        for (i in 0 ..< length) {
            yield(pos)
            pos -= Pos(1, 0)
        }

        for (i in 0 ..< length) {
            yield(pos)
            pos -= Pos(0, 1)
        }
        length++
    }
}