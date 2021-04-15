// Constructors/Task1.kt
package constructorsExercise1

class Floating (val d:Double){

  override fun toString(): String {
    return d.toString()
  }
}

fun main() {
  var f = Floating(4.0)
}