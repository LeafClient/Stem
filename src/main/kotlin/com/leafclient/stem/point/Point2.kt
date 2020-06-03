package com.leafclient.stem.point
import com.leafclient.stem.Angle
import com.leafclient.stem.vector.Vector2
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class Point2(var x: Double, var y: Double) {

    constructor(r: Double, theta: Angle): this(r * sin(theta.degrees), r * cos(theta.degrees))

    val r: Double
        get() = sqrt(x * x + y * y)

    val theta: Angle
        get() = Angle(atan(y / x))

    operator fun plus(other: Point2) =
        Point2(
            other.x + x,
            other.y + y
        )

    operator fun minus(other: Point2) =
        Point2(
            other.x - x,
            other.y - y
        )

    operator fun plus(other: Vector2) =
        Point2(
            other.x + x,
            other.y + y
        )

    operator fun minus(other: Vector2) =
        Point2(
            other.x - x,
            other.y - y
        )
}

fun point(x: Double, y: Double)
        = Point2(x, y)