package com.leafclient.maths

import com.leafclient.maths.point.Point2

class Oval(var major: Double, var minor: Double, var center: Point2) {
    val area: Double
        get() = kotlin.math.PI*major*minor

    val circle: Circle?
        get() = if(isCircle()) {Circle(major, center)} else {null}

    fun isCircle() : Boolean {
        return major == minor
    }
}