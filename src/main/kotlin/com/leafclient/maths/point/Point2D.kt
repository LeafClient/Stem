package com.leafclient.maths.point
import com.leafclient.maths.Angle
import com.leafclient.maths.vector.Vector2D
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

data class Point2D(val x: Double, val y: Double) {

    constructor(r: Double, theta: Angle): this(r * sin(theta.degrees), r * cos(theta.degrees))

    val r: Double
        get() = sqrt(x * x + y * y)

    val theta: Angle
        get() = Angle(atan(y / x))

    operator fun plus(other: Point2D) =
        Point2D(
            other.x + x,
            other.y + y
        )

    operator fun minus(other: Point2D) =
        Point2D(
            other.x - x,
            other.y - y
        )

    operator fun plus(other: Vector2D) =
        Point2D(
            other.x + x,
            other.y + y
        )

    operator fun minus(other: Vector2D) =
        Point2D(
            other.x - x,
            other.y - y
        )
}