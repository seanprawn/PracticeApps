// Summary2/Task1.kt
package summaryIIExercise1
import atomictest.eq

class Boring {
    fun a(): Double {return 1.618}
    fun b(): String {return "ratio"}
    fun c(): Int {return 11}
}

fun main() {
  var boring = Boring()
    boring.a() eq 1.618
    boring.b() eq "ratio"
    boring.c() eq 11
}