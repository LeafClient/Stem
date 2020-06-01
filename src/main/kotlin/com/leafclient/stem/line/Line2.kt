package com.leafclient.stem.line

import com.leafclient.stem.Angle
import com.leafclient.stem.point.Point2
import com.leafclient.stem.vector.Vector2
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
        val multiply = scale / (direction.x + direction.y)
        return Vector2(direction.x * multiply, direction.y * multiply)
    }

    fun getY(x: Double): Double? {
        return if(x >= start.x && x <= end.x) {
            x * slope
        } else {
            null
        }
    }

    fun xInBounds(x: Double): Boolean {
        return x <= min(start.x, end.x) && x >= max(start.x, end.x)
    }

    fun yInBounds(y: Double): Boolean {
        return y <= min(start.y, end.y) && y >= max(start.y, end.y)
    }

    /**
     * Returns whether [point] is contained inside of this line.
     */
    fun inBounds(point: Point2)
            = point.x <= min(start.x, end.x) && point.x >= max(start.x, end.x) &&
            point.y <= min(start.y, end.y) && point.y >= max(start.y, end.y)

    /**
     * Divides the lines into points separated with a precision of [precision] and
     * runs the [predicate] for each points.
     * The [predicate] should return false if the points hits an object or true if it can continues.
     */
    inline fun rayTrace(precision: Double, crossinline predicate: (Point2) -> Boolean): Boolean {
        var i = 0;
        val scale = scale(precision)
        while(
            xInBounds(start.x+(scale.x*i))
            && yInBounds(start.y+(scale.y*i))
        ) {
            if(!predicate(Point2(start.x+(scale.x*i), start.y+(scale.y*i))))
                return false
            i++
        }
        return true
    }

    fun rotate(angle: Angle)
            = Line2(
        start, length, Vector2(
            direction.x * cos(angle.degrees) - direction.y * sin(angle.degrees),
            direction.x * sin(angle.degrees) + direction.y * cos(angle.degrees)
        )
    )
}