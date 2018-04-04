case class Address(city: String, state: String)
// declare base class constructor with val or var,
// when defining the subclass constructor, leave val or var
// declaration off of the fields that are common to both classes
class Person(var name: String, var address: Address) {
  override def toString = if (address == null) name else s"$name @ $address"
}
class Employee(name: String, address: Address, var age: Int) 
extends Person(name, address) {
  // rest of the class
}

object ConstructorParamsExtendingClass extends App {
  val e = new Employee("Teresa", Address("Bangalore", "KA"), 25)
  println(e)
}
