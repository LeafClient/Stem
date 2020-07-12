package com.leafclient.stem

import com.leafclient.stem.point.Point2
import kotlin.math.cos
import kotlin.math.sin

class Square(var sideLength: Double, var point: Point2) {

    inline fun square(sideLength: Double, point: Point2) = Square(sideLength, point)

    val center: Point2
        get() = Point2(point.x+(sideLength/2), point.y+(sideLength/2))

    val area: Double
        get() = sideLength*sideLength

    val rectangle: Rectangle
        get() = Rectangle(sideLength, sideLength, center)

    val perimeter: Double
        get() = sideLength*4

    val enclosingCircle: Circle
        get() = Circle(sideLength/2, center)
}