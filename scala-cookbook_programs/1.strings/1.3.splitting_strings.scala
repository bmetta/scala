object MainObject {
  def main(args: Array[String]) {
    "hello world".split(" ").foreach(println)
    println("------- 1")

    val s = "eggs, milk, butter, coco puffs"
    s.split(",").map(_.trim).foreach(println)
    println("------- 2")
  }
}
