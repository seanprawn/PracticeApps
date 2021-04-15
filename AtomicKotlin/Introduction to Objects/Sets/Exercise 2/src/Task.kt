// Sets/Task2.kt
package setsExercise2
import kotlin.random.Random

fun experiment(): Int {
  var count = 0
  val setOfNum = mutableSetOf<Int>()
//  var res = mutableSetOf<Int>()
do {
    count++
  setOfNum += Random.nextInt(25) + 1
}while (setOfNum.size <25)
return count
}

fun main() {
  val counts = mutableListOf<Int>()
  repeat(1000) {
    counts += experiment()
  }
  println(counts.average())
}