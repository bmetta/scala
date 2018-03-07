object MainObject extends App {
  val fruits = Array("apple", "banana", "orange")
  for (fruit <- fruits)
    println(fruit)
  println("---------1")

  for (fruit <- fruits) {
    val f = fruit.toUpperCase
    println(f)
  }
  println("---------2")

  // Returning values from a for loop
  val fruits_modified = for (fruit <- fruits) yield fruit.toUpperCase
  for (fruit <- fruits_modified)  println(fruit)
  println("---------3")

  for (i <- 0 until fruits.length)
    println(s"$i is ${fruits(i)}")
  println("---------4")

  // Scala collections also offer a zipWithIndex method that you can use
  // to create a loop counter
  for ((fruit, index) <- fruits.zipWithIndex)
    println(s"$index is $fruit")
  println("---------5")

  // Looping over a Map
  val names = Map("firstname" -> "Rober",
                  "lastname"  -> "Goren")

  for ((key, value) <- names)
    println(s"$key is $value")
  println("---------6")

  val nums = List(1, 2, 3, 4, 5)
  for (n <- nums) println(n)
  // translation above line to following line performed by the compiler
  nums.foreach((n) => println(n))
  println("---------7")

  // #1 input code
  for (i <- 1 to 10)  println(i)
  println("---------8")
  // compiler output code
  // 1.to(10).foreach((i) => println(i))
  1.to(10).foreach(println)

  println("---------9")

  // #2 input code
  for {
    i <- 1 to 10
    // if (i % 2 == 0) // same as following line
    if i % 2 == 0
  } println(i)
  // compiler output code
  // 1.to(10).withFilter(i => i.$percent(2).$eq$eq(0)).foreach(i => println(i)) // same as following line
  1.to(10).withFilter(((i) => i.$percent(2).$eq$eq(0))).foreach(println)
  println("---------10")

  // #4 input code
  for (i <- 1 to 10) yield i
  // compiler output code
  1.to(10).map(((i) => i))
}
