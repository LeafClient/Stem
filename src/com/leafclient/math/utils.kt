package com.leafclient.math

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

fun toRadians(degrees: Double): Double { return kotlin.math.PI*(degrees/180) }

fun toDegrees(radians: Double): Double { return 180*(radians/kotlin.math.PI) }


fun pythagoras(x: Double, y: Double): Double { return (x*x+y*y).pow(0.5) } // sqrt(x^2 * y^2) = z |