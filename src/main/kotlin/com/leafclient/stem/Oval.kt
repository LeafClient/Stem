package com.leafclient.stem

import com.leafclient.stem.point.Point2
import kotlin.math.PI
import kotlin.math.sqrt

class Oval(var major: Double, var minor: Double, var center: Point2) {

    inline fun oval(major: Double, minor: Double, center: Point2) = Oval(major, minor, center)

    val area: Double
        get() = PI * major * minor

    val circumference: Double
        get() = 2.0 * PI * sqrt((major + minor) / 2.0)

    val circle: Circle?
        get() = if(isCircle)
            Circle(major, center)
        else
            null

    inline val isCircle: Boolean
        get() = major == minor

}