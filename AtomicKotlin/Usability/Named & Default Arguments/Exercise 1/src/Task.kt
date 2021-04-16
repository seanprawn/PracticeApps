// NamedAndDefaultArgs/Task1.kt
package namedAndDefaultArgumentsExercise1

import org.w3c.dom.css.Rect

class Rectangle(
        val side1: Double = 1.0,
        val side2:Double = 2.0,
        val color: String = "yellow",
)
{
   override fun toString(): String {
      return "Rectangle ${side1}x$side2 of '$color' color"   }
}

fun main() {
  println(Rectangle())

//without argument names
    println(Rectangle(1.1))
    println(Rectangle(1.1, 2.2, "blue"))

//    Mixed positons and named args
    println(Rectangle(1.1, 2.2, color =  "blue"))
    println(Rectangle(1.1, 2.2, "blue"))

//    names for all args
    println(Rectangle(color = "blue"))
    println(Rectangle(side1 = 1.1, side2 = 2.2, color = "blue"))


}