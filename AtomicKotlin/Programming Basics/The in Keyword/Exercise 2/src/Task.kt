// InKeyword/Task2.kt
package theInKeywordExercise2

fun sumOfEven(n: Int): Int {
  var res =0
  for (i in 0 .. n step 2)
  {
    res+=i
  }
  return res
}

fun main() {
  println(sumOfEven(10))  // 30
}