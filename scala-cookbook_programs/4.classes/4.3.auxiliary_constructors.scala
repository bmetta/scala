/**
 * auxiliary constructors needs to call the either primary constructor or one of the 
 * previously defined constructors
 */
class Pizza(var crustSize: Int, var crustType: String) {
  // one-arg auxiliary constructor
  def this(crustSize: Int) {
    this(crustSize, Pizza.DEFAULT_CRUST_TYPE)
  }
  // one-arg auxiliary constructor
  def this(crustType: String) {
    this(Pizza.DEFAULT_CRUST_SIZE, crustType)
  }
  // zero-arg auxiliary constructor
  def this() {
    this(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  }
  override def toString = s"Pizza of $crustSize inch with $crustType crust"
}
object Pizza {
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "THIN"
}

/*
object AuxiliaryConstructorsTest extends App {
  val p1 = new Pizza(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  val p2 = new Pizza(Pizza.DEFAULT_CRUST_SIZE)
  val p3 = new Pizza(Pizza.DEFAULT_CRUST_TYPE)
  val p4 = new Pizza
  println(p1)
  println(p2)
  println(p3)
  println(p4)
}
*/

// case class
case class Person(var name: String, var age: Int)

// the companion object
object Person {
  def apply() = new Person("<no name>", 0)
  def apply(name: String) = new Person(name, 0)
}

object CaseClassTest extends App {
  val a = Person() // corresponds to apply()
  val b = Person("Pam") // corresponds to apply(name: String)
  val c = Person("William Shatner", 82)

  println(a)
  println(b)
  println(c)
}
