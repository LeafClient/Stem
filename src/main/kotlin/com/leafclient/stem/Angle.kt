package com.leafclient.stem

import kotlin.math.PI

data class Angle(var degrees: Double) {

    val radians: Double
        get() = toRadians(degrees)

    companion object {
        fun toRadians(degrees: Double)
                = PI * (degrees / 180.0)

        fun toDegrees(radians: Double)
                = 180.0 * (radians/ PI)
    }

}