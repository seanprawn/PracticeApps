package constrainingVisibilityExercise2

import org.junit.Assert
import org.junit.Test
import util.TIMEOUT

class TestConstrainingVisibilityExercise2 {
  @Test(timeout = TIMEOUT)
  fun testCheckAllThePropertiesArePrivate() {
    val robotMethods = setOf("right", "left", "down", "up", "getLocation")
    val objectMethods = setOf("wait", "equals", "toString", "hashCode", "getClass", "notify", "notifyAll")
    val publicMethods = robotMethods + objectMethods

    val robotClass = Robot::class.java
    val otherMethods = robotClass.methods.filter { it.name !in publicMethods }.map { it.name }

    val (getters, methods) = otherMethods
      .filterNot { it.startsWith("set") }
      .partition { it.startsWith("get") }
    val properties = getters.map { it.substringAfter("get").decapitalize() }
    val message = buildString {
      properties.forEach {
        appendLine("The property '$it' should be private")
      }
      methods.forEach {
        appendLine("The member function '$it' should be private")
      }
    }
    Assert.assertTrue(message, otherMethods.isEmpty())
  }
}