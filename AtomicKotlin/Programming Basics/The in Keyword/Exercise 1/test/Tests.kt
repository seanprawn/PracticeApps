package theInKeywordExercise1

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestTheInKeywordExercise1 {
  @Test(timeout = TIMEOUT)
  fun test1() {
    Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", getAlphabet())
  }
}