package com.leafclient.stem

import kotlin.math.PI
import kotlin.math.sqrt

data class Angle(var yaw: Double, var pitch: Double) {

    inline val length: Double
        get() = sqrt(yaw * yaw + pitch * pitch)

    companion object {
        fun toRadian(degrees: Double)
                = PI * (degrees / 180.0)

        fun toDegree(radians: Double)
                = 180.0 * (radians/ PI)
    }

}

@Suppress("NOTHING_TO_INLINE")
inline fun angle(yaw: Double, pitch: Double) = Angle(yaw, pitch)