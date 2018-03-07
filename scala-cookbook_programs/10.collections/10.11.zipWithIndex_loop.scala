object ZipWithIndexMain extends App {
  val days = Array("Sunday", "Monday", "Tuesday", "Wednesday",
                   "Thursday", "Friday", "Saturday")
  // days.zipWithIndex generates => Array(("Sunday", 0), ("Monday", 1), ...
  days.zipWithIndex.foreach {
    case (day, count) => println(s"$count is $day")
    //x => println(s"${x._2} is ${x._1}")
  }
  println("-------- 1")

  for ((day, count) <- days.zipWithIndex) {
    println(s"$count is $day")
  }
  println("-------- 2")

  // zip with Stream to create a counter
  for ((day, count) <- days.zip(Stream from 1)) {
    println(s"$count is $day")
  }
  println("-------- 3")
}
