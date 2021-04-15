package operationsOnCollectionsExercise1

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestOperationsOnCollectionsExercise1 {
  private fun checkOldest(list: List<Person>, quantity: Int) {
    Assert.assertEquals("Wrong result for quantity = $quantity in $list:",
      list.sortedByDescending { it.age }
        .take(quantity).map { it.name }.sorted(),
      findOldest(list, quantity)
    )
  }

  @Test(timeout = TIMEOUT)
  fun test1Sample() {
    val people = listOf(
      Person("Bob", 30),
      Person("Charlie", 20),
      Person("Alice", 25))
    checkOldest(people, 1)
    checkOldest(people, 2)
  }

  @Test(timeout = TIMEOUT)
  fun test2() {
    val names = setOf("X", "Y", "Z")
    val ages = setOf(10, 20, 30)
    for (i in 1..10) {
      val people = names.shuffled().zip(ages.shuffled()) { name, age ->
        Person(name, age)
      }
      checkOldest(people, 1)
      checkOldest(people, 2)
      checkOldest(people, 32)
    }
  }
}
