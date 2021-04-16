// Testing/Task2.kt
package testingExercise2
import atomictest.eq
import atomictest.neq

fun sum(a: Int, b: Int, c: Int): Int = a + b + c

fun main() {
//  println(sum(1,2,3))
//  println(sum(10,-2,4))
//  println(sum(-11,2,3))
//  println(sum(1,2,3))
//  println(sum(1,2,3))

  sum(1,2,3) eq 6
  sum(10,-2,4) eq 12
  sum(-1,2,3) eq 4
  sum(5,2,-3) eq 4
  sum(-1,-2,-3) neq 6
}