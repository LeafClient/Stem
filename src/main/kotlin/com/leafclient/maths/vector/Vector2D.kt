package com.leafclient.maths.vector

import com.leafclient.maths.Angle
import kotlin.math.cos
import kotlin.math.sin

class Vector2D(val x: Double, val y: Double) {

    val slope: Double
        get() = y/x

    constructor(slope: Double) : this(1.0, slope)

    fun rotate(angle: Angle): Vector2D {
        return Vector2D(
            x * cos(angle.degrees) - y * sin(angle.degrees),
            x * sin(angle.degrees) + y * cos(angle.degrees)
        )
    }

    fun getX(y: Double): Double {
        return (y/this.y)*this.x
    }

    fun getY(x: Double): Double {
        return (x/this.x)*this.y
    }

    operator fun plus(other: Vector2D) =
        Vector2D(
            other.x + x,
            other.y + y
        )

    operator fun minus(other: Vector2D) =
        Vector2D(
            other.x - x,
            other.y - y
        )

    operator fun times(other: Vector2D) =
        // Dot product
        other.x * x +
        other.y * y

}