package com.leafclient.maths.vector

import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

data class Vector3D(
    val x: Double, val y: Double, val z: Double
) {

    val pitch: Double
        get() = asin(z)

    val yaw: Double
        get() = asin(y/cos(asin(z)))


    constructor(pitch: Double, yaw: Double) : this(cos(yaw)*cos(pitch), sin(yaw)*cos(pitch), sin(pitch))

    fun rotate(pitch: Double, yaw: Double): Vector3D {
        return Vector3D(this.pitch+pitch, this.yaw+yaw)
    }

    operator fun plus(other: Vector3D) =
        Vector3D(
            other.x + x,
            other.y + y,
            other.z + z
        )
    
    operator fun minus(other: Vector3D) =
        Vector3D(
            other.x - x,
            other.y - y,
            other.z - z
        )

    operator fun times(other: Vector3D) =
        // Dot product
            other.x * x +
            other.y * y +
            other.z * z

}