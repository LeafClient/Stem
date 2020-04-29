package com.leafclient.maths

import com.leafclient.maths.point.Point2

class Rectangle(var width: Double, var height: Double, var center: Point2) {
    val area: Double
        get() = width*height

    val perimeter: Double
        get() = (width*2)+(height*2)

    val squaee: Square?
        get() = if(isSquare()) {Square(width, center)} else {null}

    fun enclosingOval() : Oval {
        return Oval(width/2, height/2, center)
    }

    fun isSquare() : Boolean {
        return width == height
    }
}