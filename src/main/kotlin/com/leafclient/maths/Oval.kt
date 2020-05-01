package com.leafclient.maths

import com.leafclient.maths.point.Point2
import kotlin.math.sqrt

class Oval(var major: Double, var minor: Double, var center: Point2) {

    val area: Double
        get() = kotlin.math.PI*major*minor

    val circumference: Double
        get() = 2*kotlin.math.PI*sqrt((major+minor)/2)

    val circle: Circle?
        get() = if(isCircle) {Circle(major, center)} else {null}

    val isCircle: Boolean
        get() = major == minor

}