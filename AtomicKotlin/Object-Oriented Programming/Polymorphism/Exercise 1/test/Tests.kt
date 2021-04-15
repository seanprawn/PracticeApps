package polymorphismExercise1

import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.*
import kotlin.reflect.full.createInstance
import kotlin.test.assertEquals

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestPolymorphismExercise1 {

  private val packageName = "polymorphismExercise1"

  @Test
  fun `#01 classes structure`() {
    loadClass(packageName, "Warrior").apply {
      assertConstructorNumber(1)
      assertInheritance("Character", "Fighter")
    }
    loadClass(packageName, "Elf").apply {
      assertConstructorNumber(1)
      assertInheritance("Character", "Magician")
    }
    loadClass(packageName, "FightingElf").apply {
      assertConstructorNumber(1)
      assertInheritance("Elf", "Fighter")
    }
    loadClass(packageName, "Wizard").apply {
      assertConstructorNumber(1)
      assertInheritance("Character", "Magician", "Flyer")
    }
    loadClass(packageName, "Dragon").apply {
      assertConstructorNumber(1)
      assertInheritance("Character", "Flyer")
    }
  }

  @Test
  fun `#02 what do the characters`() {
    val result = listOf("Warrior", "Elf", "FightingElf", "Dragon", "Wizard")
      .map { loadClass(packageName, it).createInstance() as Character }
      .map { c -> c.playTurn() }

    assertEquals(
      message = "Incorrect result of playTurn() for all characters",
      actual = result,
      expected = listOf(
        "Warrior: Fight!",
        "Elf: Magic!",
        "FightingElf: Magic!Fight!",
        "Dragon: Fly!",
        "Magician: Magic!Fly!"
      )
    )
  }
}
