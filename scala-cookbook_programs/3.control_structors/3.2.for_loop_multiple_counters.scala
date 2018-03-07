/**
 * iterating over a multi‐ dimensional array.
 */
object MainObject extends App {
  for (i <- 1 to 2; j <- 1 to 2) println(s"$i, $j")

  // preferred style for multiline for loops is to use curly brackets:
  for {
    i <- 1 to 2
    j <- 1 to 2
  } println(s"$i, $j")

  // two-dimensional array
  val array = Array.ofDim[Int](2, 2)
  array(0)(0) = 0
  array(0)(1) = 1
  array(1)(0) = 2
  array(1)(1) = 3
  for {
    i <- 0 until 2
    j <- 0 until 2
  } println(s"${array(i)(j)}")
}
