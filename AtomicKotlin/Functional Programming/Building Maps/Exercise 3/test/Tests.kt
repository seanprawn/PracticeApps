package buildingMapsExercise3

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT
import kotlin.collections.associateBy as associateByLibrary

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestBuildingMapsExercise3 {
  private fun <T, R> check(
    list: List<T>,
    keySelector: (T) -> R,
    keySelectorStr: String
  ) {
    Assert.assertEquals("Wrong result for $list associated by $keySelectorStr",
      list.associateByLibrary(keySelector),
      list.associateBy(keySelector))
  }

  @Test(timeout = TIMEOUT)
  fun test1Sample() = check(listOf(Person("Alice", 21),
    Person("Bob", 25), Person("Charlie", 25)),
    Person::age, "Person::age")

  @Test(timeout = TIMEOUT)
  fun test2() = check(listOf("abc", "ahh", "never"),
    { it.first() }, "{ it.first() }")

  @Test(timeout = TIMEOUT)
  fun test3() = check((1..5).toList(), { it }, "{ it }")

  @Test(timeout = TIMEOUT)
  fun test4() = check(listOf(Person("Alice", 21),
    Person("Bob", 25), Person("Charlie", 25)),
    Person::name, "Person::name")
}