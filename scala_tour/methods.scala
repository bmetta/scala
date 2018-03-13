object Methods extends App {
  def add(x: Int, y: Int): Int = x + y
  println(add(1, 2)) // 3

  // Methods can take multiple parameter lists
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(addThenMultiply(2, 3)(10)) // 50

  def addMultiplyDivide(x: Int, y: Int)(multiplier: Int)(divider: Int): Int =
      (x + y) * multiplier / divider
  println(addMultiplyDivide(2, 3)(10)(2)) // 25

  // no parameter lists at all
  def name: String = System.getProperty("user.name")
  println("Hello, " + name + "!")

  // Methods can have multi-line expressions as well
  def getSquareString(input: Double): String = {
    val sqaure = input * input
    // last expression in the body is the method's return value
    // scala does have a return keyword, but its rarely used
    sqaure.toString
  }
  println(getSquareString(9))
}
