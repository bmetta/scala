object LoopingCollectionFor extends App {
  val fruits = Traversable("apple", "banana", "orange")
  for (f <- fruits) println(f)
  for (f <- fruits) println(f.toUpperCase)
  println ("---------- 1")

  val fruits2 = Array("apple", "banana", "orange")
  for (i <- 0 until fruits2.size) println(s"$i ${fruits2(i)}")
  println ("---------- 2")

  for ((f, i) <- fruits2.zipWithIndex) println(s"$i $f")
  println ("---------- 3")

  for ((f, i) <- fruits2.zip(Stream from 1)) println(s"$i $f")
  println ("---------- 4")

  // for/yield construct returns (yields) a new collection from the
  // input collection
  val newArray = for (fruit <- fruits) yield {
    val upper = fruit.toUpperCase
    upper
  }
  for (fruit <- newArray) println(fruit)
  println ("---------- 5")

  val names = Map("fname" -> "Ed", "lname" -> "Knab")
  for ((k, v) <- names) println(s"$k: $v")
  println ("---------- 6")
}
