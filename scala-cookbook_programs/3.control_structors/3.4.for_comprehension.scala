/**
 * for Comprehension (for/yield Combination)
 */
object MainObject extends App {
  val names = Array("chris", "ed", "maurice")
  val capNames = for (name <- names) yield name.length
  for (name <- capNames) println (name)
}
