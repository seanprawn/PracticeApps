package variableArgumentListsExercise1

import org.junit.Assert
import org.junit.Test
import util.TIMEOUT
import util.runAndGetSystemOutput

class TestVariableArgumentListsExercise1 {
  @Test(timeout = TIMEOUT)
  fun testMessageInOutput() {
    val output = runAndGetSystemOutput {
      main()
    }
    val message = "Multiple vararg-parameters are prohibited"
    Assert.assertTrue("The output should contain '$message'.\nWas: $output", message in output)
  }
}