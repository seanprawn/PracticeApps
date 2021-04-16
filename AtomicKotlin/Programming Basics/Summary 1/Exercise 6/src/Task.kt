// Summary1/Task6.kt
package summaryIExercise6

fun everyFifthNonWhitespace(s: String) {

  var j = 1
  for (i in s)
  {
    if (j%5 == 0 && i != ' ')
    {
      println(i)
    }
      if (i != ' ')
        {
          j++
        }



  }
}

fun main() {
  everyFifthNonWhitespace("abc d e fgh ik")
}
/* Output:
e
k
*/