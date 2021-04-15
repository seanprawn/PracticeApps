// RepetitionWithWhile/Task3.kt
package repetitionWithWhileExercise3

fun sumOfEven(n: Int): Int {
  var i = 0
  var result = 0
  while (i<=n)
  {
    if (i%2 == 0)
    result +=i
    i++
  }
  return result
}

fun main() {
  println(sumOfEven(10))  // 30
}