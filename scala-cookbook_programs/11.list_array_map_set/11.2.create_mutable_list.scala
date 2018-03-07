object MainObject extends App {
  val fruits = new ListBuffer[String]()

  fruits += "Apple"
  fruits += "Banana"
  fruits += "Orange"

  fruits += ("Strawberry", "Kiwi", "Pineapple")
  fruits -= "Banana"
}
