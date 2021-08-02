// ExceptionHandling/ExceptHandlingSoln1.kt
package exceptionHandlingExercise1
import kotlin.random.Random

data class Hamster(val name: String)

open class HamsterCageException(
  val msg: String
): Exception() {
  override fun toString() =
    "HamsterCageException: $msg"
}

class CageFullException(val limit: Int) :
  HamsterCageException("Cage full > $limit")

class NoSuchHamsterException(val id: String) :
  HamsterCageException("No Hamster $id")

class OutOfWaterException :
  HamsterCageException("Cage out of water")

class HamsterCage(val capacity: Int) {
  private val seed = Random(47)
  private val cage = HashSet<Hamster>()
  fun add(h: Hamster) {
    if (cage.size >= capacity)
      throw CageFullException(capacity)
    cage.add(h)
  }
  fun get(name: String): Hamster {
    for (h in cage)
      if (h.name == name)
        return h
    throw NoSuchHamsterException(name)
  }
  fun feed(): String {
    if ((0..10).random(seed) > 8)
      throw OutOfWaterException()
    return "Feeding complete"
  }
}

val hamsters = listOf(
  Hamster("Sally"), Hamster("Ralph"),
  Hamster("Bob"), Hamster("Sergio"),
  Hamster("Allison"), Hamster("Jane"))

fun test(hc: HamsterCage) {
  try {
    for (h in hamsters) {
      println("$h")
      hc.add(h)
    }
  } catch (e: CageFullException) {
    println("$e")
  }
  try {
    println("${hc.get(hamsters[0].name)}")
    println("${hc.get("Morty")}")
  } catch (e: NoSuchHamsterException) {
    println("$e")
  }
  try {
    println(hc.feed())
    println(hc.feed())
    println(hc.feed())
  } catch (e: OutOfWaterException) {
    println("$e")
  }
}

fun main() {
  test(HamsterCage(3))
}
/* Output:
Hamster(name=Sally)
Hamster(name=Ralph)
Hamster(name=Bob)
Hamster(name=Sergio)
HamsterCageException: Cage full > 3
Hamster(name=Sally)
HamsterCageException: No Hamster Morty
Feeding complete
HamsterCageException: Cage out of water
*/