object MainObject extends App {
  val a = Array(12, 6, 15, 2, 20, 9)
  println(a.reduceLeft(_ + _))
  println(a.reduceLeft(_ min _))
  println(a.reduceLeft(_ max _))

  // Show each step in the process
  val findMax = (x: Int, y: Int) => {
    (x max y)
  }
  println(a.reduceLeft(findMax))
  println(a.reduceLeft((x, y) => if (x > y) x else y))

  // scanleft: returns new sequence
  val b = Array(1, 2, 3, 4, 5)
  val product = (x: Int, y: Int) => {
    val prod = x * y
    println(s"$x * $y = $prod")
    prod
  }
  b.scanLeft(10)(product)
}
