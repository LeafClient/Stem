package com.leafclient.maths.line

import com.leafclient.maths.point.Point3
import com.leafclient.maths.vector.Vector3
import kotlin.math.max
import kotlin.math.min

class Line3(var start: Point3, var end: Point3) {
    val direction : Vector3
        get() = Vector3(end.x-start.x, end.y-start.y, end.z-start.z)

    val length : Double
        get() = Math.sqrt((end.x - start.x)*(end.x - start.x) + (end.y - start.y)*(end.y - start.y) + (end.z - start.z)*(end.z - start.z));

    constructor(
        point: Point3, length: Double, direction: Vector3
    ): this(point,
        Point3(
            point.x + (direction.x * length),
            point.y + (direction.y * length),
            point.z + (direction.z * length)
        )
    )

    fun scale(scale: Double): Vector3 {
        var scalesquared = scale*scale
        var multiply = scale/(direction.x+direction.y+direction.z)
        return Vector3(direction.x*multiply, direction.y*multiply, direction.z*multiply)
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

    fun inBounds(point: Point3): Boolean {
        return  point.x <= min(start.x, end.x) && point.x >= max(start.x, end.x) &&
                point.y <= min(start.y, end.y) && point.y >= max(start.y, end.y) &&
                point.z <= min(start.z, end.z) && point.z >= max(start.z, end.z)
    }

    fun points(precision: Double): HashSet<Point3> {
        var i = 0;
        val scale = scale(precision)
        var toReturn = HashSet<Point3>()
        while(xInBounds(start.x+(scale.x*i)) && yInBounds(start.y+(scale.y*i)) && zInBounds(start.z+(scale.z*i))) {
            toReturn.add(Point3(start.x+(scale.x*i), start.y+(scale.y*i), start.z+(scale.z*i)))
        }
        return toReturn
    }

    fun rotate(pitch: Double, yaw: Double) : Line3 {
        return Line3(
            start,
            length,
            direction.rotate(pitch, yaw)
        )
    }

    //  Todo: Get points; A bit confused on how to do it ngl and its l8. Ill figure it out tmrw
}