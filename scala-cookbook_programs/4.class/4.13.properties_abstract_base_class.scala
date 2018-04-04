/**
 * abstract or concrete properties in an abstract base class (or trait) that can be
 * referenced in all child classes
 */

abstract class Pet(name: String) {
  // 1: abstract fields in the abstract class or trait doesnot create a field in
  // resulting code. It only generates the methods that corresponds to val or var field
  val greeting: String // generates getter method
  var age: Int  // generates setter and getter methods
  
  def sayHello { println(greeting) }
  override def toString = s"I say $greeting, and I'm $age year old"

  // 2: define a def that takes no parameters rather than defining a val
  def greeting1: String

  // 3: concrete val in abstract class; created in base class
  val greeting2 = "Hello" // provide an initial value

  // final val greeting2 = "Hello" // compiler error in derived class if its override

  // 4: concrete var field in abstract class
  var greeting3 = "Hello"
}

class Dog(name: String) extends Pet(name) {
  // Because of Pet 1: , the concrete values for the base class fields in the concrete class
  // must again define the fields to be val or var
  // override keyword is not necessary
  val greeting = "Woof"
  var age = 2

  // 2: can define val in the concrete class
  val greeting1 = "Woof1"

  // 3: instance created
  override val greeting2 = "Woof2" // override the value

  // 4: refer to base class concrete var
  greeting3 = "Woof3"
}
class Cat(name: String) extends Pet(name) {
  val greeting = "Meow"
  var age = 3

  // 2: can define val in the concrete class
  val greeting1 = "Meow1"

  // 3: instance created
  override val greeting2 = "Meow2" // override the value

  // 4: refer to base class concrete var
  greeting3 = "Meow3"
}

object AbstractFieldsTest extends App {
  val dog = new Dog("Fido")
  val cat = new Cat("Morris")
  dog.sayHello
  cat.sayHello

  println(dog)
  println(cat)

  cat.age = 10
  println(cat)

  println(dog.greeting1)
}
