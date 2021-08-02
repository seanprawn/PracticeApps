package variableArgumentListsExercise3

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestVariableArgumentListsExercise3 {

  private fun checkListOfChunks(size: Int, vararg elements: String) {
    Assert.assertEquals("Incorrect result for size = $size, elements = ${elements.toList()}.",
      elements.toList().chunked(size), listOfChunks(size, *elements))
  }

  @Test(timeout = TIMEOUT)
  fun testSameList() = checkListOfChunks(3, "a", "b", "c")

  @Test(timeout = TIMEOUT)
  fun testSmallerList() = checkListOfChunks(3, "a")

  @Test(timeout = TIMEOUT)
  fun testFixedNumberOfElements() = checkListOfChunks(2, "a", "b", "c", "d")

  @Test(timeout = TIMEOUT)
  fun testExtraElements() = checkListOfChunks(2, "a", "b", "c", "d", "e")
}