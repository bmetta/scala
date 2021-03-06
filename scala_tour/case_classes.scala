/**
 * case classes are immutable and compared by value
 * case classes are good for modeling immutable data
 * used for pattern matching
 */
case class Point(x: Int, y: Int)

object CaseClasses extends App {
  val p1 = Point(1, 2)
  val p2 = Point(1, 2)
  val p3 = Point(2, 2)

  if (p1 == p2) {
    println("p1 equal p2")
  } else {
    println("p1 not equal p2")
  } // p1 equal p2

  if (p1 == p3) {
    println("p1 equal p3")
  } else {
    println("p1 not equal p3")
  } // p1 not equal p3

}
