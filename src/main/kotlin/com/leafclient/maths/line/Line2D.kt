package com.leafclient.maths.line

import com.leafclient.maths.Angle
import com.leafclient.maths.point.Point2D
import com.leafclient.maths.vector.Vector2D
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

    fun getY(x: Double): Double? {
        if(x >= start.x && x <= end.x) {
            return x*this.slope
        } else {
            return null
        }
    }

    fun points(precision: Double): HashSet<Point2D> {
        var i = start.x;
        var toReturn = HashSet<Point2D>()
        while(i <= end.x) {
            getY(i)?.let { Point2D(i, it) }?.let { toReturn.add(it) }
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