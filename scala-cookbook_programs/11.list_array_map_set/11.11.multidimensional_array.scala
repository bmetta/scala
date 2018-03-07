/**
 * Multidimentional Arrays
 * Array.ofDim
 */

object MainObject extends App {
  val rows = 2
  val cols = 3
  val a = Array.ofDim[String](rows, cols)
  a(0)(0) = "a"
  a(0)(1) = "b"
  a(0)(2) = "c"
  a(1)(0) = "d"
  a(1)(1) = "e"
  a(1)(2) = "f"

  for {
    i <- 0 until rows
    j <- 0 until cols
  } println(s"($i)($j) = ${a(i)(j)}")
}
