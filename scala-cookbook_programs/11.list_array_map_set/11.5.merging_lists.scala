// merge/concatenate the contents of two lists
// Merge two lists using the ++, concat, or ::: methods.
object MainObject extends App {
  val a = List(1, 2, 3)
  val b = List(4, 5, 6)

  val c = a ::: b 
  val d = a ++ b
  val e = List.concat(a, b)
}
