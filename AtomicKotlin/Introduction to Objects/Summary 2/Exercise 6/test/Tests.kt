package summaryIIExercise6

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT
import util.loadMemberProperty
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestSummaryIIExercise6 {
  private enum class MeasureSystem(val title: String) {
    FAHRENHEIT("fahrenheit"), CELSIUS("celsius");

    override fun toString(): String = title
  }

  private class TempValue(val value: Double, val system: MeasureSystem)

  private fun testChange(initial: TempValue, expected: TempValue) {
    val temp = Temperature()
    val initialProp = loadMemberProperty(temp::class, initial.system.title)
    val expectedProp = loadMemberProperty(temp::class, expected.system.title)

    fun assertMutable(tempValue: TempValue, prop: KProperty<*>) {
      Assert.assertTrue("The '${tempValue.system}' property is expected to be mutable", prop is KMutableProperty<*>)
    }
    assertMutable(initial, initialProp)
    assertMutable(expected, expectedProp)

    (initialProp as KMutableProperty<*>).setter.call(temp, initial.value)
    val actual = expectedProp.getter.call(temp)
    Assert.assertEquals("The '${expected.system}' property is expected to be ${expected.value} " +
      "after setting '${initial.system}' to ${initial.value}", expected.value, actual)
  }

  @Test(timeout = TIMEOUT)
  fun test1Fahrenheit() {
    testChange(TempValue(90.0, MeasureSystem.FAHRENHEIT), TempValue(90.0, MeasureSystem.FAHRENHEIT))
  }

  @Test(timeout = TIMEOUT)
  fun test2Celsius() {
    testChange(TempValue(30.0, MeasureSystem.CELSIUS), TempValue(30.0, MeasureSystem.CELSIUS))
  }

  @Test(timeout = TIMEOUT)
  fun test3Change() {
    testChange(TempValue(86.0, MeasureSystem.FAHRENHEIT), TempValue(30.0, MeasureSystem.CELSIUS))
  }

  @Test(timeout = TIMEOUT)
  fun test4Change() {
    testChange(TempValue(30.0, MeasureSystem.CELSIUS), TempValue(86.0, MeasureSystem.FAHRENHEIT))
  }
}