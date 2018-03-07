// 10.9. Looping over a Collection with foreach
object LoopingCollection extends App {
  val x = Vector(1, 2, 3)
  x.foreach(println)
  println ("------- 1")

  x.foreach(println(_))
  println ("------- 2")
  
  x.foreach(i => println(i))
  println ("------- 3")
  
  x.foreach((i: Int) => println(i))
  println ("------- 4")

  // method takes one parameter of the same type as the elements
  // in the collection and returns nothing (Unit)
  // it can be called from a foreach method
  def printIt(c: Char) { println(c) }
  "HAL".foreach(printIt)
  println ("------- 5")

  "HAL".foreach(c => printIt(c))
  println ("------- 6")

  "HAL".foreach((c: Char) => println(c))
  println ("------- 7")

  val longWords = new StringBuilder
  "Hello world it's Al".split(" ").foreach { e =>
    println(e)
    if (e.length > 4)
      longWords.append(s" $e")
    else
      println("Not added: " + e)
  }
  longWords.foreach(println)
  println ("------- 8")

  val m = Map("fname" -> "Tyler", "lname" -> "LeDude")
  m foreach (x => println(s"${x._1} -> ${x._2}"))
  println ("------- 9")
  m.foreach {
    case (key, value) => println(s"key: $key, value: $value")
  }
  println ("------- 10")
}
