package com.leafclient.stem.vector

import com.leafclient.stem.Angle
import kotlin.math.cos
import kotlin.math.sin

data class Vector2(var x: Double, var y: Double) {

    val slope: Double
        get() = y/x

    constructor(slope: Double) : this(1.0, slope)

    fun rotate(angle: Angle)
            = Vector2(
        x * cos(angle.degrees) - y * sin(angle.degrees),
        x * sin(angle.degrees) + y * cos(angle.degrees)
    )

    fun getX(y: Double)
            = (y/this.y)*this.x

    fun getY(x: Double)
            = (x/this.x)*this.y

    operator fun plus(other: Vector2) =
        Vector2(
            other.x + x,
            other.y + y
        )

    operator fun minus(other: Vector2) =
        Vector2(
            other.x - x,
            other.y - y
        )

    operator fun times(other: Vector2) =
        // Dot product
        other.x * x +
        other.y * y

}

/**
 * A function used to create vector easily and make the syntax around mathematical functions
 * look better.
 */
fun vec(x: Double, y: Double)
        = Vector2(x, y)