// NumberTypes/Task4.kt
package numberTypesExercise4

fun convertToMilliseconds(hours: Int, minutes: Int, seconds: Int): Long =
  (((hours*60L+minutes)*60) + seconds )*1000

fun main() {
  println(convertToMilliseconds(1, 30, 0))
}

//1 hour = 60 minutes = 60 × 60 seconds = 3600 seconds = 3600 × 1000 milliseconds = 3,600,000 ms.