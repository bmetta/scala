/**
 * trait PartialFunction[-A, +B] extends (A) => B
 * Partial function of type PartialFunction[A, B] is a unary function
 * (A) => B can be interpreted as a function that transforms a type A
 * into a resulting type B.
 */
object PartialFunction extends App {
  /**
   * Normal function that divides one number by another
   */
  //val divide = (x: Int) => 42 / x
  //divide(0) // java.lang.ArithmeticException: / by zero

  /**
   * using PartialFunction
   */
  val divide = new PartialFunction[Int, Int] {
    def apply(x: Int) = 42 / x
    def isDefinedAt(x: Int) = x != 0
  }
  if (divide.isDefinedAt(1)) // true
    println(divide(1)) // 42
  if (divide.isDefinedAt(0)) // false
    println(divide(0))

  /**
   *  Partial functions written with case statement
   *  This doesnt explicitly implement the isDefinedAt method,
   *  it works exactly same as the previous divide function
   */
  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }
  if (divide2.isDefinedAt(1)) // true
    println(divide2(1)) // 42
  if (divide2.isDefinedAt(0)) // false
    println(divide2(0))

  val sample = 1 to 10
  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x + " is even"
  }
  val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 != 0 => x + " is odd"
  }
  val numbers = sample map (isEven orElse isOdd)
  println(numbers)

  // collect method is written to test the isDefinedAt method for
  // each element it’s given
  val oddNumbers = sample collect (isOdd)
  println(oddNumbers)
  val evenNumbers = sample collect (isEven)
  println(evenNumbers)
}
