package com.leafclient.math

import sun.security.util.Length
import kotlin.math.cos
import kotlin.math.sin

class Line2D(val start: Point2D, val end: Point2D) {
    val direction = Vector2D(end.x-start.x, end.y-start.y)
    val length = pythagoras(start.x-end.x, start.y-end.y)

    constructor(point: Point2D, length: Double, direction: Vector2D) : this(point, Point2D(point.x+(direction.x*length), point.y+(direction.y*length)))

    fun rotate(angle: Angle): Line2D {
        return Line2D(start, length, Vector2D(
            direction.x*cos(angle.degrees) - direction.y*sin(angle.degrees),
            direction.x*sin(angle.degrees) + direction.y*cos(angle.degrees)
        ))
    }
}