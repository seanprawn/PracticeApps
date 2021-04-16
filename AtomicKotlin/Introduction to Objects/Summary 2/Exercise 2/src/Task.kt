// Summary2/Task2.kt
package summaryIIExercise2
import atomictest.eq

class Boring2
  (val a:Double,
  val b: String,
  val c: Int )
{
  fun a() = a
  fun b() = b
  fun c() = c
}

fun main() {
  var boring = Boring2(1.618, "ratio", 11)
  boring.a() eq 1.618
  boring.b() eq "ratio"
  boring.c() eq 11
}