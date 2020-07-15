package com.leafclient.stem

import com.leafclient.stem.point.Point2
import kotlin.math.PI

class Circle(var radius: Double, var center: Point2) {

    val circumference: Double
        get() = 2.0 * PI * radius

    val area: Double
        get() = PI * radius * radius

    val oval: Oval
        get() = Oval(radius, radius, center)

}

@Suppress("NOTHING_TO_INLINE")
inline fun circle(radius: Double, center: Point2) = Circle(radius, center)