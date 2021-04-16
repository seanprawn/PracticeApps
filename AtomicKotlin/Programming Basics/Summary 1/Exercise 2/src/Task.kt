// Summary1/Task2.kt
package summaryIExercise2

fun other(s: String): String {
  var res = ""
  var number = 0

  for (i in s)
  {
    if(number%2==0) res+=i
    number++
  }

  return res
}

fun main() {
  println(other("cement"))
}
/* Output:
cmn
*/