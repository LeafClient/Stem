package com.leafclient.maths.line

import com.leafclient.maths.point.Point2D
import com.leafclient.maths.point.Point3D
import com.leafclient.maths.vector.Vector2D
import com.leafclient.maths.vector.Vector3D

data class Line3D(val start: Point3D, val end: Point3D) {
    val direction : Vector3D
        get() = Vector3D(end.x-start.x, end.y-start.y, end.z-start.z)

    val length : Double
        get() = Math.sqrt((end.x - start.x)*(end.x - start.x) + (end.y - start.y)*(end.y - start.y) + (end.z - start.z)*(end.z - start.z));

    constructor(
        point: Point3D, length: Double, direction: Vector3D
    ): this(point,
        Point3D(
            point.x + (direction.x * length),
            point.y + (direction.y * length),
            point.z + (direction.z * length)
        )
    )

    fun rotate(pitch: Double, yaw: Double) : Line3D {
        return Line3D(
            start,
            length,
            direction.rotate(pitch, yaw)
        )
    }

    //  Todo: Get points; A bit confused on how to do it ngl and its l8. Ill figure it out tmrw
}