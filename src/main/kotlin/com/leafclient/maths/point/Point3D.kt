package com.leafclient.maths.point

data class Point3D(val x: Double, val y: Double, val z: Double) {
    operator fun plus(other: Point3D) =
        Point3D(
            other.x + x,
            other.y + y,
            other.z + z
        )

    operator fun minus(other: Point3D) =
        Point3D(
            other.x - x,
            other.y - y,
            other.z - z
        )
}