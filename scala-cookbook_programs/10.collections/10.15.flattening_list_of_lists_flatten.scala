object MainObject extends App {
  val lol = List(List(1, 2), List(3, 4, 5), List(6, 7))
  val lol_flat = lol.flatten
  lol_flat.foreach(n => println(n))
  lol_flat.foreach(println)
  for(n <- lol_flat) println(n)
  println("------ 1")

  val couples = List(List("kim", "al"), List("julia", "terry"), List("tom", "jerry"))
  couples.flatten.map(_.capitalize).sorted.foreach(println)
  println("------ 2")

  val list = List("Hello", "world")
  val chars = list.flatten // List(H, e, l, l, o, w, o, r, l, d)
  chars.foreach(println)
  println("------ 3")
}
