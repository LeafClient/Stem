package com.leafclient.maths.line

import com.leafclient.maths.Angle
import com.leafclient.maths.point.Point2D
import com.leafclient.maths.point.Point3D
import com.leafclient.maths.vector.Vector2D
import com.leafclient.maths.vector.Vector3D
import kotlin.math.*

data class Line2D(val start: Point2D, val end: Point2D) {

    val direction: Vector2D
        get() = Vector2D(end.x - start.x, end.y - start.y)

    val length: Double
        get() = sqrt((end.x + end.x)*(end.y + end.y))

    val slope: Double
        get() = (start.y-end.y)/(start.x-end.x)

    constructor(
        point: Point2D, length: Double, direction: Vector2D
    ): this(point,
        Point2D(
            point.x + (direction.x * length),
            point.y + (direction.y * length)
        )
    )

    fun scale(scale: Double): Vector2D {
        var scalesquared = scale*scale
        var multiply = scale/(direction.x+direction.y)
        return Vector2D(direction.x*multiply, direction.y*multiply)
    }

    fun getY(x: Double): Double? {
        if(x >= start.x && x <= end.x) {
            return x*this.slope
        } else {
            return null
        }
    }

    fun xInBounds(x: Double): Boolean {
        return x <= min(start.x, end.x) && x >= max(start.x, end.x)
    }

    fun yInBounds(y: Double): Boolean {
        return y <= min(start.y, end.y) && y >= max(start.y, end.y)
    }

    fun inBounds(point: Point2D): Boolean {
        return  point.x <= min(start.x, end.x) && point.x >= max(start.x, end.x) &&
                point.y <= min(start.y, end.y) && point.y >= max(start.y, end.y)
    }

    fun points(precision: Double): HashSet<Point2D> {
        var i = 0;
        val scale = scale(precision)
        var toReturn = HashSet<Point2D>()
        while(xInBounds(start.x+(scale.x*i)) && yInBounds(start.y+(scale.y*i))) {
            toReturn.add(Point2D(start.x+(scale.x*i), start.y+(scale.y*i)))
        }
        return toReturn
    }

    fun rotate(angle: Angle): Line2D {
        return Line2D(
            start, length, Vector2D(
                direction.x * cos(angle.degrees) - direction.y * sin(angle.degrees),
                direction.x * sin(angle.degrees) + direction.y * cos(angle.degrees)
            )
        )
    }
}