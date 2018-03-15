/**
 * Multiple parameter lists (currying)
 *  Currying: Methods may define multiple parameter lists. When a method is called with a
 *  fewer number of parameter lists, then this will yield a function taking the
 *  missing parameter lists as its arguments
 */
object Currying extends App {
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val numberFunc = numbers.foldLeft(List[Int]())_

  val sqaures = numberFunc((xs, x) => xs:+ x * x)
  println(sqaures.toString)

  val cubes = numberFunc((xs, x) => xs:+ x * x * x)
  println(cubes.toString)
}
