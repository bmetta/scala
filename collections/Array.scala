/**
 *  Arrays are mutable, indexed collections of values. Array[T] is Scala's
 *  representation for Java's T[].
 */
object Array extends App {
  val a = Array(1, 2, 3, 4, 5)
  
  /**
   * def addString(b: StringBuilder): StringBuilder
   * 
   * b        string builder to which elements are appended
   * returns  string builder b to which elements were appended
   */
  val b = new StringBuilder
  val aStr = a.addString(b) // 12345
  println(aStr)

  // def addString(b: StringBuilder, sep: String): StringBuilder
  val b1 = new StringBuilder
  val aStr1 = a.addString(b1, ", ") // 1, 2, 3, 4, 5
  println(aStr1)

  // def addString(b: StringBuilder, start: String, sep: String, end: String): StringBuilder
  val b2 = new StringBuilder
  val aStr2 = a.addString(b2, "Array(", ", ", ")") // 1, 2, 3, 4, 5
  println(aStr2)

  /**
   * def aggregate[B](z: ⇒> B)(seqop: (B, T) ⇒> B, combop: (B, B) ⇒> B): B
   */
  val agg = a.aggregate(0) (
    { (acc, value) => acc + value },
    { (acc1, acc2) => acc1 + acc2 }
  )
  println(agg)  // 15

  /**
   * def canEqual(that: Any): Boolean
   */
  val c = Array(1, 2, 3, 4, 5)
  val isEqual = c.canEqual(a) // true
  println(isEqual)

  /**
   * def collect[B](pf: PartialFunction[A, B]): Array[B]
   *
   * Builds a new collection by applying a partial function to all elements
   * of this sequence on which the function is defined
   */
  val d = Array(0, 1, "2", "3", Some(4), Some("5"))
  val pf: PartialFunction[Any, Int] = {
    case i: Int => i
    case s: String => s.toInt
    case Some(s: String) => s.toInt
  }
  d.collect(pf).foreach(println) // 0 1 2 3 4 5

  /**
   * def collectFirst[B](pf: PartialFunction[T, B]): Option[B]
   */
  d.collectFirst(pf).foreach(println) // 0
}
