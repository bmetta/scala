/**
 * scala offers lightweight notation for expressing sequence comprehensions
 * for (enumerators) yield e
 */

object ForComprehensions extends App {
  case class User(val name: String, val age: Int)

  val userBase = List(
      new User("Travis", 28),
      new User("Kelly", 33),
      new User("Jennifer", 44),
      new User("Dennis", 23)
    )
  val twentySomethings = for (user <- userBase if (user.age >= 20 && user.age < 30))
                             yield user.name // add this to a list
  twentySomethings.foreach(name => println(name)) // prints Travis, Dennis

  
  // Computes all pairs of numbers between 0 and n-1 whose sum is equal
  // to a given value v
  def forloop(n: Int, v: Int) = {
    for (i <- 0 until n;
         j <- i until n if i + j == v)
    yield (i, j)
  }

  forloop(10, 10) foreach {
    case (i, j) => println(s"$i, $j")
  }
}
