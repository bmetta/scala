/**
 * Iterator is knowing that it's exhausted after you use it
 * Iterator isn't a collection
 * Iterator can be converted to a collection when needed
 */
object IteratorMain extends App {
  val it = Iterator(1, 2, 3)
  it.foreach(println)
  it.foreach(println) // no output here, because iterator has been exhausted
  println("------ 1")

  val it1 = Iterator(1, 2, 3, 4)
  it1.toArray.foreach(x => println(x))
  println("------ 2")
}
