// CreatingClasses/Task2.kt
package creatingClassesExercise2

class Giraffe
{
    fun displayID()
    {
        var res = this.toString()
       println(res.substringAfter('@'))
//    println(this)
    }
}

fun main() {

  val giraffe1 = Giraffe()
  val giraffe2 = Giraffe()
  val giraffe3 = Giraffe()
  giraffe1.displayID()
  giraffe2.displayID()
  giraffe3.displayID()

}