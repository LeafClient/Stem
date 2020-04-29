package com.leafclient.maths

import com.leafclient.maths.point.Point2

class Circle(var radius: Double, var center: Point2) {
    val circumference: Double
        get() = 2*kotlin.math.PI*radius

    val area: Double
        get() = kotlin.math.PI*radius*radius

    val oval: Oval
        get() = Oval(radius, radius, center)
}

