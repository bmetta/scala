object MainObject {
  def main(args: Array[String]) {
    val s1 = "Hello"
    val s2 = "Hello"
    println(s1 == s2) // true
    println("-------- 1")

    val s3 = "Hello"
    val s4 = "heLlo"
    println(s3.toUpperCase == s4.toUpperCase) // true
    println("-------- 2")
    println(s3.equalsIgnoreCase(s4)) // true
    println("-------- 3")
  }
}
