package com.leafclient.maths.point

import com.leafclient.maths.vector.Vector3

class Point3(var x: Double, var y: Double, var z: Double) {
    operator fun plus(other: Point3) =
        Point3(
            other.x + x,
            other.y + y,
            other.z + z
        )

    operator fun minus(other: Point3) =
        Point3(
            other.x - x,
            other.y - y,
            other.z - z
        )

    operator fun plus(other: Vector3) =
        Point3(
            other.x + x,
            other.y + y,
            other.z + z
        )

    operator fun minus(other: Vector3) =
        Point3(
            other.x - x,
            other.y - y,
            other.z - z
        )
}