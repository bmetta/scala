// calculate the sum of the numbers in a list
object MainObject extends App {
  val bag = List("1", "2", "three", "4", "one hundred seventy five")

  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in.trim))
    } catch {
      case e: Exception => None
    }
  }

  val bag_int = for (str <- bag) yield toInt(str)
  bag_int.foreach(println)
  println("------ 1")
  println(bag_int.flatten.sum)
  println("------ 2")

  // TODO: difference between bag.map(toInt) and bag.map(_.toInt)
  println(bag.map(toInt).flatten.sum)
  println("------ 3")

  // Above code is equivalent to the following line
  println(bag.flatMap(toInt).sum)
  println("------ 4")

  bag.flatMap(toInt).filter(_ > 1).foreach(println)
  println("------ 5")

  bag.flatMap(toInt).takeWhile(_ < 4).foreach(println)
  println("------ 6")

  bag.flatMap(toInt).partition(_ > 3) // output: (List(4),List(1, 2))
  println("------ 7")
}
