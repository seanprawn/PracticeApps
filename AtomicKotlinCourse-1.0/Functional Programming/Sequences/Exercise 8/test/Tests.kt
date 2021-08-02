package sequencesExercise8

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestSequencesExercise8 {
  @Test(timeout = TIMEOUT)
  fun test1Sample() {
    Assert.assertEquals("Wrong result for sample",
      listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34),
      fibonacci().take(10).toList())
  }
}