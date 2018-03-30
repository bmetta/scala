/**
 * type inference:
 *  scala compiler can often infer the type of an expression so you dont have to
 *  declare it explicitly
 */

object RecursiveMethod extends App {
  // Note: for recursive methods, the compiler is not able to infer a result type
  // def fact(n: Int) = { // compiler error
  def fact(n: Int): Int = { // works
    if (n == 0) 1 else n * fact(n - 1)
  }

  println(fact(6))
}
