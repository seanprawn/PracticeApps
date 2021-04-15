// Varargs/Task2.kt
package variableArgumentListsExercise2

fun printArgs(str: String, vararg num: Int) {
    var res = num.toList()
//    for (i in num) res += "$i"
    println("$str$res")
}

fun main() {
  printArgs("Numbers:", 1, 2, 3)
}
/* Expected output:
Numbers: [1, 2, 3]
 */