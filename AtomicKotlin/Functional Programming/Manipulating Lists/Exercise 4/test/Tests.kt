package manipulatingListsExercise4

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestManipulatingListsExercise4 {
  @Test(timeout = TIMEOUT)
  fun test1Sample() {
    val alice = Person("Alice")
    val bob = Person("Bob")
    val charlie = Person("Charlie")

    alice.friends += bob
    bob.friends += alice
    bob.friends += charlie
    charlie.friends += bob

    Assert.assertEquals("Wrong result for sample",
      setOf(charlie), friendSuggestions(alice))
  }

  @Test(timeout = TIMEOUT)
  fun test2() {
    val persons = (0..6).map { Person("#$it") }
    fun connection(i: Int, j: Int) {
      persons[i].friends += persons[j]
      persons[j].friends += persons[i]
    }
    connection(0, 1)
    connection(0, 2)
    connection(1, 3)
    connection(1, 4)
    connection(5, 6)

    Assert.assertEquals("Wrong suggestions for #0 in $persons",
      listOf(3, 4).map { persons[it] }.toSet(),
      friendSuggestions(persons[0]))
  }

  @Test(timeout = TIMEOUT)
  fun test3() {
    val persons = (0..2).map { Person("#$it") }
    fun connection(i: Int, j: Int) {
      persons[i].friends += persons[j]
      persons[j].friends += persons[i]
    }
    connection(0, 1)
    connection(0, 2)
    connection(1, 2)

    Assert.assertEquals("Wrong suggestions for #0 in $persons",
      setOf<Person>(),
      friendSuggestions(persons[0]))
  }

  @Test(timeout = TIMEOUT)
  fun test4() {
    val persons = (0..4).map { Person("#$it") }
    fun connection(i: Int, j: Int) {
      persons[i].friends += persons[j]
      persons[j].friends += persons[i]
    }
    connection(0, 1)
    connection(0, 2)
    connection(1, 3)
    connection(3, 4)

    Assert.assertEquals("Wrong suggestions for #0 in $persons",
      setOf(persons[3]),
      friendSuggestions(persons[0]))
  }


  @Test(timeout = TIMEOUT)
  fun test5() {
    val persons = (0..6).map { Person("#$it") }
    fun connection(i: Int, j: Int) {
      persons[i].friends += persons[j]
      persons[j].friends += persons[i]
    }
    connection(0, 1)
    connection(0, 2)
    connection(1, 3)
    connection(3, 4)
    connection(2, 4)

    Assert.assertEquals("Wrong suggestions for #0 in $persons",
      listOf(3, 4).map { persons[it] }.toSet(),
      friendSuggestions(persons[0]))
  }
}