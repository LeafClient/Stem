package com.leafclient.stem.line

import com.leafclient.stem.point.Point3
import com.leafclient.stem.vector.Vector3
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

class Line3(var start: Point3, var end: Point3) {

    inline fun line(start: Point3, end: Point3) = Line3(start, end)

    val direction : Vector3
        get() = Vector3(end.x-start.x, end.y-start.y, end.z-start.z)

    val length : Double
        get() = sqrt((end.x - start.x)*(end.x - start.x) + (end.y - start.y)*(end.y - start.y) + (end.z - start.z)*(end.z - start.z));

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
        val multiply = scale/(direction.x+direction.y+direction.z)
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

    /**
     * Divides the lines into points separated with a precision of [precision] and
     * runs the [predicate] for each points.
     * The [predicate] should return false if the points hits an object or true if it can continues.
     */
    inline fun rayTrace(precision: Double, crossinline predicate: (Point3) -> Boolean): Boolean {
        var i = 0
        val scale = scale(precision)
        while(xInBounds(start.x+(scale.x*i)) && yInBounds(start.y+(scale.y*i)) && zInBounds(start.z+(scale.z*i))) {
            if(!predicate(Point3(start.x+(scale.x*i), start.y+(scale.y*i), start.z+(scale.z*i)))) {
                return false
            }
            i++
        }
        return true
    }

    fun rotate(pitch: Double, yaw: Double) : Line3 {
        return Line3(
            start,
            length,
            direction.rotate(pitch, yaw)
        )
    }
}