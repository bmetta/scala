/**
 * class name should be capitalized
 */
class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit = {
    println(prefix + name + suffix)
  }
}

// private members and getter/setter syntax
class Point {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  // Methods for accessing the private data
  def x = _x
  def y = _y

  // Setters of the private data
  // special syntax for the setters: the method has _= appended to the
  // identifier of the getter and the parameters come after.
  def x_= (newVal: Int): Unit = {
    if (newVal < bound) _x = newVal else printWarning
  }
  def y_= (newVal: Int): Unit = {
    if (newVal < bound) _y = newVal else printWarning
  }
  private def printWarning() = println("WARNING: Out of bounds")
}

object Class extends App {
  val greeter = new Greeter("Hello ", "!")
  greeter.greet("Developer")

  val p = new Point
  p.x = 10
  p.y = 101 // prints the warning
}

