package com.leafclient.math

class Angle(val degrees: Double) {
    val radians: Double
        get() = toRadians(degrees)
}