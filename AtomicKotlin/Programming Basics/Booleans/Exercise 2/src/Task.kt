// Booleans/Task2.kt
package booleansExercise2

fun showAnd(first: Boolean, second: Boolean) {
  val result = first&&second
  var answer = "$first && $second == $result"
  println(answer)
}

fun showOr(first: Boolean, second: Boolean) {
  val result = first||second
  var answer = "$first || $second == $result"
  println(answer)
}

fun showTruthTable() {
  showAnd(true, true)
  showAnd(false, true)
  showAnd(true, false)
  showAnd(false, false)

  showOr(true, true)
  showOr(true, false)
  showOr(false, true)
  showOr(false,false)
}

fun main() {
  showTruthTable()
}