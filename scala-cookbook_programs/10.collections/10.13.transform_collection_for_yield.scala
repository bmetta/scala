object MainObject extends App {
  case class Person (name: String)
  val friends = Vector("Mark", "Regina", "Matt")
  for (f <- friends) yield Person(f)
  // o/p: Vector[Person] = Vector(Person(Mark), Person(Regina), Person(Matt))
}
