// ExpressionsStatements/Task2.kt
package expressionsAndStatementsExercise2

fun f(a:Int, b:Int) = a+b

fun g(s1:String, s2:String) = s1+s2

fun h() = println("h()")

fun main() {
  val num = f(5,8)
  val str = g("hello ", "there")
  val prnt = h()

  println("Int")
  println("String")
  println("Unit")
}