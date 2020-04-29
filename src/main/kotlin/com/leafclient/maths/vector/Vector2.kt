package com.leafclient.maths.vector

import com.leafclient.maths.Angle
import kotlin.math.cos
import kotlin.math.sin

class Vector2(var x: Double, var y: Double) {

    val slope: Double
        get() = y/x

    constructor(slope: Double) : this(1.0, slope)

    fun rotate(angle: Angle): Vector2 {
        return Vector2(
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