package recursionExercise3

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestRecursionExercise3 {
  @Test(timeout = TIMEOUT)
  fun test1Sample() {
    Assert.assertEquals("Wrong result for sample",
      "[0, 1, 1, 2, 3, 5, 8, 13, 21]",
      (0..8).map { fibonacciIterative(it) }.toString())
    Assert.assertEquals("Wrong result for sample",
      17711, fibonacciIterative(22))
    Assert.assertEquals("Wrong result for sample",
      12586269025, fibonacciIterative(50))
  }

  private fun checkNumber(n: Int, fib: Long) {
    Assert.assertEquals("Wrong Fibonacci value for $n",
      fib, fibonacciIterative(n))
  }

  @Test(timeout = TIMEOUT)
  fun test2() = checkNumber(17, 1597)

  @Test(timeout = TIMEOUT)
  fun test3() = checkNumber(33, 3524578)

  @Test(timeout = TIMEOUT)
  fun test4() = checkNumber(39, 63245986)
}