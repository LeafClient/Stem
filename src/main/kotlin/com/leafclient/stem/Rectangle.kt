package com.leafclient.stem

import com.leafclient.stem.point.Point2

class Rectangle(var width: Double, var height: Double, var point: Point2) {

    inline fun rectangle(width: Double, height: Double, point: Point2) = Rectangle(width, height, point)

    val center: Point2
        get() = Point2(point.x+(width/2), point.y+(height/2))

    val area: Double
        get() = width*height

    val perimeter: Double
        get() = (width*2)+(height*2)

    val square: Square?
        get() = if(isSquare) Square(width, center) else null

    val enclosingOval: Oval
        get() = Oval(width/2, height/2, center)

    inline val isSquare: Boolean
        get() = width == height

}