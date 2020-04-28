package com.leafclient.maths

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

}