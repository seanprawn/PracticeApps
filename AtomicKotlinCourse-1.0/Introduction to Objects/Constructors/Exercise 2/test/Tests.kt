package constructorsExercise2

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.*

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestConstructorsExercise2 {
  class RobotHandler(fieldSize: Int, var x: Int, var y: Int) {
    val robot: Robot = run {
      val robotClass = loadClass("constructorsExercise2", "Robot")
          .apply {
            assertConstructorNumber(1)
            assertParametersOfFirstConstructor(
                "fieldSize" to Int::class,
                "x" to Int::class,
                "y" to Int::class
            )
          }
      robotClass.createInstance(fieldSize, x, y) as Robot
    }
    val loggedMovements = StringBuilder()

    fun goRight(steps: Int) {
      robot.right(steps)
      loggedMovements.appendLine("right($steps)")
    }

    fun goLeft(steps: Int) {
      robot.left(steps)
      loggedMovements.appendLine("left($steps)")

    }

    fun goDown(steps: Int) {
      robot.down(steps)
      loggedMovements.appendLine("down($steps)")

    }

    fun goUp(steps: Int) {
      robot.up(steps)
      loggedMovements.appendLine("up($steps)")
    }
  }

  private fun testMovements(location: String, fieldSize: Int, x: Int, y: Int,
                            movements: RobotHandler.() -> Unit) {
    val robotHandler = RobotHandler(fieldSize, x, y)
    robotHandler.movements()
    val actualLocation = robotHandler.robot.getLocation()
    val message = if (robotHandler.loggedMovements.isEmpty()) {
      "Initial location of the robot should be ($x, $y)"
    } else {
      "Starting location: ($x, $y), field size: $fieldSize.\n" +
          "Wrong location after:\n" + robotHandler.loggedMovements
    }
    Assert.assertEquals(message, location, actualLocation)
  }

  @Test(timeout = TIMEOUT)
  fun test1Initial() = testMovements("(2, 3)", 10, 2, 3) {}

  @Test(timeout = TIMEOUT)
  fun test2Right() = testMovements("(3, 3)", 10, 2, 3) {
    goRight(1)
  }

  @Test(timeout = TIMEOUT)
  fun test3Circle() = testMovements("(2, 3)", 10, 2, 3) {
    goRight(10)
    goLeft(10)
    goDown(10)
    goUp(10)
  }
}