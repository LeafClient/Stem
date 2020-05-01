package com.leafclient.maths

import com.leafclient.maths.point.Point2
import kotlin.math.PI

class Circle(var radius: Double, var center: Point2) {
    val circumference: Double
        get() = 2* PI*radius

    val area: Double
        get() = PI*radius*radius

    val oval: Oval
        get() = Oval(radius, radius, center)
}

