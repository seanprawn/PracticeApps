// Summary2/Task5.kt
package summaryIIExercise5

fun va1(vararg input: Int) {
    println("va1:")
    for (i in input) {
        println(i)
    }
}

fun va2(vararg input: Int) {
    println("va2:")
    va1(*input)
}

fun main() {

  va1(1, 2, 3)
  va2(4, 5, 6)

}
/* Expected output:
va1:
1
2
3
va2:
va1:
4
5
6
 */