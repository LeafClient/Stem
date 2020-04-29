package com.leafclient.maths.point

import com.leafclient.maths.vector.Vector2D
import com.leafclient.maths.vector.Vector3D

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

    operator fun plus(other: Vector3D) =
        Point3D(
            other.x + x,
            other.y + y,
            other.z + z
        )

    operator fun minus(other: Vector3D) =
        Point3D(
            other.x - x,
            other.y - y,
            other.z - z
        )
}