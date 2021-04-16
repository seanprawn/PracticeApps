// NamedAndDefaultArgs/Task3.kt
package namedAndDefaultArgumentsExercise3
import atomictest.eq

fun joinComments(s: String): String {
  val lines: List<String> = s.lines()
  var liners = listOf<String>()
  var out = ""
  for (i in lines)
  {
//    i.removePrefix("// ").trimMargin()
//    println(i)
    liners += i.trim().trimMargin(marginPrefix = "; ").removePrefix("//").toUpperCase()
//    i.trim().removePrefix("[")
  }
//  println(out)
//  println("Sean! "+liners)
  return liners.joinToString(separator = ";", prefix = "", postfix = "").removePrefix(";").trimMargin().removeSuffix(";")
}

fun main() {
  val s = """
        // First
        // Second
        // Third
        """
  joinComments(s) eq "First; Second; Third"
}