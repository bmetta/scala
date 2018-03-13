/**
 * Traits are used to share interfaces and fields between classes
 * Traits can have default implementations
 * Similar to Java 8's interfaces
 */

trait Greeter {
  def greet(name: String): Unit = {
    println("Hello, " + name + "!")
  }
}

class DefaultGreeter extends Greeter
class CustomizableGreeter(prefix: String, suffix: String) extends Greeter {
  override def greet(name: String): Unit = {
    println(prefix + name + suffix)
  }
}

/*
object Traits extends App {
  val greeter = new DefaultGreeter()
  greeter.greet("Developer")

  val customGreeter = new CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Developer")
}
*/
/**
 *
 */
trait Iterator[A] {
  def hasNext(): Boolean
  def next(): A
}

class IntIterator(upperBound: Int) extends Iterator[Int] {
  private var current = 1
  override def hasNext(): Boolean = current < upperBound
  override def next(): Int = {
    if (hasNext) {
      val ret = current
      current += 1
      ret
    } else 0
  }
}

object IteratorExample extends App {
  val iter = new IntIterator(10)
  println(iter.next()) // 1
  println(iter.next()) // 2
}
