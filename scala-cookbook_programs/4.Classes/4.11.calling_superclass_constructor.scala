/**
 * Base:
 *  primary ctor
 *  auxiliary ctor => can call auxiliary or primary of same class
 * Derived:
 *  primary ctor => can call auxiliary or primary of Base class
 *  auxiliary ctor => can call auxiliary or primary of same class
 */

case class Address(city: String, state: String)
case class Role(role: String)

class Person(var name: String, var address: Address) {
  def this(name: String) {
    this(name, null)
  }
  override def toString = if (address == null) name else s"$name @ $address"
}
class Employee(name: String, role: Role, address: Address)
extends Person(name, address) {
  def this(name: String) {
    this(name, null, null)
  }
  def this(name: String, role: Role) {
    this(name, role, null)
  }
  def this(name: String, address: Address) {
    this(name, null, address)
  }
}

object CallingSuperclassConstructor extends App {
  val e = new Employee("Tom")
  println(e)
}
