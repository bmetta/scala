object MainObject extends App {
  // Scala you just use a normal if statement to achieve the ternary effect
  val x = if (true) true else false
  println(x)

  val nieces = List("Emily", "Hannah", "mercedes", "Porsche")
  for (niece <- nieces) {
    for (c <- niece if c.isUpper)
      println(c)
  }

  // TODO: compilation error
  for { 
    niece <- nieces
    c <- niece
    if c.isUpper
      println(c)
  }
}
