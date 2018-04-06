/**
 * method takes variable arguments (varargs)
 *  varargs field must be the last field in the method signature
 *  method can have only one varargs field
 *
 *  define varargs field in the method declaration by adding * character after the field type
 *  use _* operator to adapt a sequence (Array, List, Seq, Vector, etc)
 */

object VarargsTest extends App {
/*
  def printAll(strings: String*) {
    strings.foreach(println)
  }

  printAll()
  printAll("foo")
  printAll("foo", "bar")
  printAll("foo", "bar", "baz")

  val fruits = List("apple", "banana", "cherry")
  printAll(fruits: _*)
*/
  
/*  
  def printAll(numbers: Int*) {
    println(numbers.getClass)
    numbers.foreach(println)
  }
  printAll(1, 2, 3)
  printAll()

  val numbers = List(1, 2, 3, 4, 5)
  printAll(numbers: _*)
*/

  def printAll(strings: Any*) {
    strings.foreach(println)
  }
  
  printAll()
  
  printAll("foo", "bar")

  printAll(1, 2, 3)

  val numbers = List(1, 2, 3, 4, 5)
  printAll(numbers: _*)

}
