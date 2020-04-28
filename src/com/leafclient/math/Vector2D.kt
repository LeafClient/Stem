package com.leafclient.math

import kotlin.math.cos
import kotlin.math.sin

class Vector2D(val x: Double, val y: Double) {
    fun rotate(angle: Angle): Vector2D {
        return Vector2D(
            x*cos(angle.degrees) - y*sin(angle.degrees),
            x*sin(angle.degrees) + y*cos(angle.degrees)
        )
    }
}