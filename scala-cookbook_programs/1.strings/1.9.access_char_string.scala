object MainObject extends App {
  val str = "hello"
  println(str.charAt(0)) // java method // h
  println(str(1)) // scala converts str(1) to str.apply(1)  // e
  println(str.apply(1)) // e
}
