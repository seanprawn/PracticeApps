// InKeyword/Task1.kt
package theInKeywordExercise1

fun getAlphabet(): String {
  var string = ""
  for (i in 'a'..'z')
  {
    string +=i
  }
  return string
}

fun main() {
  println(getAlphabet())  // abcdefghijklmnopqrstuvwxyz
}