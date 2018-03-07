/**
 * Scala doesn’t have break or continue keywords, but it does offer
 * similar functionality through scala.util.control.Breaks.
 */
import util.control.Breaks._
// break and breakable aren’t actually keywords; they’re methods
// in scala.util.control.Breaks

object MainObject extends App {
  breakable {
    for (i <- 1 to 10) {
      if (i > 4) break // break out of the for loop
      println(i)
    }
  }
  println

  // continue
  for (i <- 1 to 10) {
    breakable {
      if (i % 2 == 0)
        break // continue the loop
      println(i)
    }
  }
}
