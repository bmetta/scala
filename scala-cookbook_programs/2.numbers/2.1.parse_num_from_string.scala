object MainObject extends App {
  println(Short.MinValue)
  println(Short.MaxValue)

  // toInt, toDouble, toFloat, toLong, toShort, toByte
  println("100".toInt)

  // Handling a base and radix
  println(Integer.parseInt("1", 2))
  println(Integer.parseInt("10", 2))
  println(Integer.parseInt("100", 2))
  println(Integer.parseInt("1", 8))
  println(Integer.parseInt("10", 8))

  // NumberFormatException: scala doesnt have checked exceptions, but
  // exceptions are handled with Option/Some/None pattern
  // It takes a String as input and returns a Some[Int] if the String
  // is successfully converted to an Int, otherwise it returns a None
  def toInt(s: String): Option[Int] = {
    try {
      //Some(s.toInt)
      Some(Integer.parseInt(s))
    } catch {
      case e: NumberFormatException => None
    }
  }

  val value1 = toInt("200")
  if (value1 != None) println(value1.get)

  val value2 = toInt("A")
  if (value2 != None) println(value2.get) else println(value2)

  toInt("200") match {
    case Some(n) => println(n)
    case None    => println(None)
  }
}

