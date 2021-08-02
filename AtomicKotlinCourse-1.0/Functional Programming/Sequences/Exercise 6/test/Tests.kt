package sequencesExercise6

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestSequencesExercise6 {
  @Test(timeout = TIMEOUT)
  fun test1Sample() {
    Assert.assertEquals("Wrong result for sample",
      listOf(10, 11),
      from(10).take(2).toList())
  }

  @Test(timeout = TIMEOUT)
  fun test2() {
    Assert.assertEquals("Wrong first elements of 'from(1000)' sequence:",
      (1000..1010).toList(),
      from(1000).take(11).toList())
  }
}