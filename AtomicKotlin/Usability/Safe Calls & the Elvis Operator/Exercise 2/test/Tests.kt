package safeCallsAndTheElvisOperatorExercise2

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestSafeCallsAndTheElvisOperatorExercise2 {
  @Test(timeout = TIMEOUT)
  fun test1SampleFromMunich() {
    val client = Client("Alice",
      PersonalInfo(address = Address("Germany", "Munich")))
    Assert.assertTrue("Client $client comes from Munich",
      client.fromMunich())
  }

  @Test(timeout = TIMEOUT)
  fun test2SampleNotFromMunich() {
    val client = Client("Bob")
    Assert.assertFalse("Client $client doesn't come from Munich",
      client.fromMunich())
  }
}