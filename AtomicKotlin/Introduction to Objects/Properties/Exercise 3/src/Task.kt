// Properties/Task3.kt
package propertiesExercise3

class Robot {
  var x = 0
  var y = 0
  val fieldSize = 100

  fun right(steps: Int) {
    x += steps
    x = crossBoundary(x)
  }

  fun left(steps: Int) {
    x -= steps
    x = crossBoundary(x)
  }

  fun down(steps: Int) {
    y += steps
    y = crossBoundary(y)
  }

  fun up(steps: Int) {
    y -= steps
    y = crossBoundary(y)
  }

  fun getLocation(): String = "($x, $y)"

  fun crossBoundary(coord:Int) :Int {
    val bounds = coord % fieldSize
    return if (bounds < 0){
      fieldSize+bounds

    }else
    {
      bounds
    }
  }
}

fun main() {
  val robot = Robot()
  println(robot.getLocation())
  robot.up(1)
  println(robot.getLocation())
  robot.left(10)
  println(robot.getLocation())
}
/* Output:
(0, 0)
(0, 99)
(90, 99)
*/