package com.leafclient.maths

import com.leafclient.maths.point.Point2

class Square(var sideLength: Double, var center: Point2) {
    val area: Double
        get() = sideLength*sideLength

    val rectangle: Rectangle
        get() = Rectangle(sideLength, sideLength, center)

    val perimeter: Double
        get() = sideLength*4

    val enclosingCircle: Circle
        get() = Circle(sideLength/2, center)
}