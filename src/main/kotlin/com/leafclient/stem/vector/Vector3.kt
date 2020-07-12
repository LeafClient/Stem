package com.leafclient.stem.vector

import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

data class Vector3(
    var x: Double, var y: Double, var z: Double
) {

    val pitch: Double
        get() = asin(z)

    val yaw: Double
        get() = asin(y/cos(asin(z)))


    constructor(pitch: Double, yaw: Double) : this(cos(yaw)*cos(pitch), sin(yaw)*cos(pitch), sin(pitch))

    fun rotate(pitch: Double, yaw: Double): Vector3 {
        return Vector3(this.pitch+pitch, this.yaw+yaw)
    }

    operator fun plus(other: Vector3) =
        Vector3(
            other.x + x,
            other.y + y,
            other.z + z
        )
    
    operator fun minus(other: Vector3) =
        Vector3(
            other.x - x,
            other.y - y,
            other.z - z
        )

    operator fun times(other: Vector3) =
        // Dot product
            other.x * x +
            other.y * y +
            other.z * z

}

/**
 * A function used to create vector easily and make the syntax around mathematical functions
 * look better.
 */
inline fun vec(x: Double, y: Double, z: Double)
        = Vector3(x, y, z)