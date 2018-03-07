object MainObject extends App {
  val nums = List.range(1, 10)
  val even_nums = nums.filter(_ % 2 == 0)
  even_nums.foreach(println)
  println("------- 1")

  val list = "apple" :: "banana" :: 1 :: 2 :: Nil
  val strings = list.filter {
    case s: String => true
    case _ => false
  }
  strings.foreach(println)
  println("------- 2")

  def onlyStrings(a: Any) = a match {
    case s: String => true
    case _ => false
  }
  val strings1 = list.filter(onlyStrings)
  strings1.foreach(println)
  println("------- 3")
}
