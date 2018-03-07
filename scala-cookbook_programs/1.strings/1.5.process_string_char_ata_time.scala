object MainObject extends App {
  // map: treats a String as a sequential collection of Char elements.
  // map method has an implicit loop, and in that loop, it passes one
  // Char at a time to the algorithm it’s given
  val upper1 = "hello world".map(c => c.toUpper)
  println(upper1)
  println("------ 1")

  val upper2 = "hello world".map(_.toUpper)
  println(upper2)
  println("------ 2")

  // treat a String as a sequence of characters in a for loop
  for (c <- "Hello World")  print(c)
  println
  println("------ 3")

  // yield statement
  val upper3 = for (c <- "hello world") yield c.toUpper
  println(upper3)
  println("------ 4")

  val upper4 = for (c <- "hello world" if c != 'l') yield c.toUpper
  println(upper4)
  println("------ 5")

  // foreach: iterates over each character of a string
  "hello world".foreach(print)
  println("------ 6")

  def toLower(c: Char): Char = (c.toByte + 32).toChar
  println("HELLO".map(toLower))
  println("------ 7")

  // getBytes: returns an array of ints
  "hello".getBytes.foreach(println)
  println("------ 8")
}
