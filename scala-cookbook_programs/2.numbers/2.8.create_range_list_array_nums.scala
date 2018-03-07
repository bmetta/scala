object MainObject extends App {
  val r = (1 to 10).toArray
  //val r = (1 to 10).toList
  println(r)
  for (i <- r) print(s"$i ")
  println

  for (i <- 1 to 10)  print(s"$i ")
  println

  for (i <- 1 until 10)  print(s"$i ")
  println

  for (i <- 1 to 10 by 2)  print(s"$i ")
  println
}
