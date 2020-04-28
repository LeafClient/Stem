package com.leafclient.maths

data class Vector3D(
    val x: Double, val y: Double, val z: Double
) {

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
        Vector3D(
            other.x * x,
            other.y * y,
            other.z * z
        )

}