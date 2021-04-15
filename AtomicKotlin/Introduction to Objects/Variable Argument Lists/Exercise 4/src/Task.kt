// Varargs/Task4.kt
package variableArgumentListsExercise4
import atomictest.eq

fun flatten(listOfLists: List<List<String>>): List<String> {
  var res = mutableListOf<String>()
  for (i in listOfLists) res.addAll(i)
  return res
}

fun main() {
  val listOfLists = listOf(listOf("a", "b"), listOf("c", "d"))
  flatten(listOfLists) eq listOf("a", "b", "c", "d")
}