package numberTypesExercise4

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestNumberTypesExercise4 {
  @Test(timeout = TIMEOUT)
  fun test1() {
    Assert.assertEquals("One hour and a half is 5_400_000 milliseconds",
      5_400_000, convertToMilliseconds(1, 30, 0))
  }

  @Test(timeout = TIMEOUT)
  fun test2() {
    Assert.assertEquals("One billion hours is 3_600_000_000_000_000 milliseconds " +
      "(note that only Long variable can store this value)",
      3_600_000_000_000_000, convertToMilliseconds(1_000_000_000, 0, 0))
  }
}