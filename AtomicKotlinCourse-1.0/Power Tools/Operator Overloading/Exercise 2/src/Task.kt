// OperatorOverloading/OpOverloadingSoln2.kt
package operatorOverloadingExercise2

enum class Count {
  Eeny, Meeny, Miney, Moe;
  companion object {
    val max = Moe
  }
}

operator fun Count.inc(): Count =
  Count.values()[
    (this.ordinal + 1) % Count.values().size
  ]

operator fun Count.dec(): Count =
  if (this.ordinal - 1 < 0)
    Count.max
  else
    Count.values()[this.ordinal - 1]

fun main() {
  var c = Count.Eeny
  for (n in 1..4) {
    println("${c++} -> $c")
  }
  println("---------------")
  for (n in 1..4) {
    println("${++c} -> $c")
  }
  println("---------------")
  for (n in 1..4) {
    println("${c--} -> $c")
  }
  println("---------------")
  for (n in 1..4) {
    println("${--c} -> $c")
  }
}
/* Exercise Output:
Eeny -> Meeny
Meeny -> Miney
Miney -> Moe
Moe -> Eeny
---------------
Meeny -> Meeny
Miney -> Miney
Moe -> Moe
Eeny -> Eeny
---------------
Eeny -> Moe
Moe -> Miney
Miney -> Meeny
Meeny -> Eeny
---------------
Moe -> Moe
Miney -> Miney
Meeny -> Meeny
Eeny -> Eeny
*/