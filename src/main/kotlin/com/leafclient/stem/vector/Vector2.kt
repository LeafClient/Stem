package com.leafclient.stem.vector

import com.leafclient.stem.Angle
import kotlin.math.cos
import kotlin.math.sin

data class Vector2(var x: Double, var y: Double) {

    val slope: Double
        get() = y/x

    constructor(slope: Double) : this(1.0, slope)

    fun rotate(angle: Angle) = Vector2(
        x * cos(angle.length) - y * sin(angle.length),
        x * sin(angle.length) + y * cos(angle.length)
    )

    fun getX(y: Double) = (y / this.y) * this.x

    fun getY(x: Double) = (x / this.x) * this.y

    operator fun plus(other: Vector2) = Vector2(
            other.x + x,
            other.y + y
    )

    operator fun minus(other: Vector2) = Vector2(
            other.x - x,
            other.y - y
    )

    operator fun times(other: Vector2) =
        // Dot product
        other.x * x +
        other.y * y

}

@Suppress("NOTHING_TO_INLINE")
inline fun vec(x: Double, y: Double) = Vector2(x, y)