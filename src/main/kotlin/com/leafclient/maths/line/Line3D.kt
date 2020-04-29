package com.leafclient.maths.line

import com.leafclient.maths.point.Point2D
import com.leafclient.maths.point.Point3D
import com.leafclient.maths.vector.Vector2D
import com.leafclient.maths.vector.Vector3D
import kotlin.math.max
import kotlin.math.min

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

    fun scale(scale: Double): Vector3D {
        var scalesquared = scale*scale
        var multiply = scale/(direction.x+direction.y+direction.z)
        return Vector3D(direction.x*multiply, direction.y*multiply, direction.z*multiply)
    }

    fun xInBounds(x: Double): Boolean {
        return x <= min(start.x, end.x) && x >= max(start.x, end.x)
    }

    fun yInBounds(y: Double): Boolean {
        return y <= min(start.y, end.y) && y >= max(start.y, end.y)
    }

    fun zInBounds(z: Double): Boolean {
        return z <= min(start.z, end.z) && z >= max(start.z, end.z)
    }

    fun inBounds(point: Point3D): Boolean {
        return  point.x <= min(start.x, end.x) && point.x >= max(start.x, end.x) &&
                point.y <= min(start.y, end.y) && point.y >= max(start.y, end.y) &&
                point.z <= min(start.z, end.z) && point.z >= max(start.z, end.z)
    }

    fun points(precision: Double): HashSet<Point3D> {
        var i = 0;
        val scale = scale(precision)
        var toReturn = HashSet<Point3D>()
        while(xInBounds(start.x+(scale.x*i)) && yInBounds(start.y+(scale.y*i)) && zInBounds(start.z+(scale.z*i))) {
            toReturn.add(Point3D(start.x+(scale.x*i), start.y+(scale.y*i), start.z+(scale.z*i)))
        }
        return toReturn
    }

    fun rotate(pitch: Double, yaw: Double) : Line3D {
        return Line3D(
            start,
            length,
            direction.rotate(pitch, yaw)
        )
    }

    //  Todo: Get points; A bit confused on how to do it ngl and its l8. Ill figure it out tmrw
}