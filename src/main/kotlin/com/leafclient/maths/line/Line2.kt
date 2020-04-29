package com.leafclient.maths.line

import com.leafclient.maths.Angle
import com.leafclient.maths.point.Point2
import com.leafclient.maths.vector.Vector2
import kotlin.math.*

class Line2(var start: Point2, var end: Point2) {

    val direction: Vector2
        get() = Vector2(end.x - start.x, end.y - start.y)

    val length: Double
        get() = sqrt((end.x + end.x)*(end.y + end.y))

    val slope: Double
        get() = (start.y-end.y)/(start.x-end.x)

    constructor(
        point: Point2, length: Double, direction: Vector2
    ): this(point,
        Point2(
            point.x + (direction.x * length),
            point.y + (direction.y * length)
        )
    )

    fun scale(scale: Double): Vector2 {
        var scalesquared = scale*scale
        var multiply = scale/(direction.x+direction.y)
        return Vector2(direction.x*multiply, direction.y*multiply)
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

    fun inBounds(point: Point2): Boolean {
        return  point.x <= min(start.x, end.x) && point.x >= max(start.x, end.x) &&
                point.y <= min(start.y, end.y) && point.y >= max(start.y, end.y)
    }

    fun points(precision: Double): HashSet<Point2> {
        var i = 0;
        val scale = scale(precision)
        var toReturn = HashSet<Point2>()
        while(xInBounds(start.x+(scale.x*i)) && yInBounds(start.y+(scale.y*i))) {
            toReturn.add(Point2(start.x+(scale.x*i), start.y+(scale.y*i)))
        }
        return toReturn
    }

    fun rotate(angle: Angle): Line2 {
        return Line2(
            start, length, Vector2(
                direction.x * cos(angle.degrees) - direction.y * sin(angle.degrees),
                direction.x * sin(angle.degrees) + direction.y * cos(angle.degrees)
            )
        )
    }
}