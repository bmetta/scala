class Person(var firstName: String, var lastName: String) {
  println("constructor begins here")
  
  var age = 0
  override def toString = s"$firstName $lastName with age $age"
  def printFullName { println(this) } // uses toString

  printFullName
  println("Still in the constructor")
}

object PrimaryConstructor extends App {
  println("object creation started")
  val p = new Person("Tim", "Cook")
  p.age = 50
  println("object created")
}
