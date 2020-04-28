package com.leafclient.math

import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.sin

class Point2D(val x: Double, val y: Double) {
    val r = pythagoras(x, y)
    val theta = Angle(atan(y/x))

    constructor(r: Double, theta: Angle) : this(r*sin(theta.degrees), r*cos(theta.degrees))
}