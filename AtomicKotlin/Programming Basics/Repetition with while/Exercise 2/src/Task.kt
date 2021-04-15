// RepetitionWithWhile/Task2.kt
package repetitionWithWhileExercise2

fun sum(number: Int): Int {
  var i = 0
  var result:Int = 0
  while (i <= number)
  {
    result +=i
    i++
  }
  return result
}

fun main() {
  println(sum(10))  // 55
}