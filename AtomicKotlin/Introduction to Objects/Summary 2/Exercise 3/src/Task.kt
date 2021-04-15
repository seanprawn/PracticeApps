// Summary2/Task3.kt
package summaryIIExercise3
import atomictest.*
import com.sun.org.apache.xml.internal.utils.MutableAttrListImpl
import operatoroverloading.E

class FixedSizeHolder(private val maxNumber:Int) {
    private val list = mutableListOf<Any>()

    val size: Int
        get() = list.size

    val full: Boolean
        get() = list.size == maxNumber


    fun add(item: Any) {

        if (full)
            throw IllegalStateException("The container is full")
        list += item
    }
}

fun main() {
/*
  val holder = FixedSizeHolder(2)
  holder.add("What is the answer?")
  holder.add(42)
  holder.full eq true
  holder.size eq 2
  capture {
    holder.add("!!!")
  } eq "IllegalStateException: The container is full"
*/
}