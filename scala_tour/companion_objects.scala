/**
 * companion object: an object with the same name as a class/trait
 * class is the object's companion class
 * a companion class or object can access the private members of its companion
 * Use a companion object for methods and values which are not specific to instances
 * of the companion class
 *
 * An analog to a companion object in Java is having a class with static methods.
 * In Scala you would move the static methods to a Companion object.
 * 
 */
/*
import scala.math._

object CompanionObject extends App {
  case class Circle(radius: Double) {
    import Circle._
    def area: Double = calculateArea(radius)
  }

  object Circle {
    private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
  }

  val circle = Circle(5.0)
  println(circle.area)
}
*/

/**
 *        (class)              (class)
 *      AnimalCounter           Animal
 *       /        \              /  \
 *     Dog        Cat          Dog  Cat
 *        (object)             (class)
 */
abstract class AnimalCounter {
  var animals = 0
  def name: String
  def count() {
    animals += 1
    println("%d %ss created so far".format(animals, name))
  }
}

abstract class Animal {
  println("Animal class enter")
  def companion: AnimalCounter
  companion.count()
  println("Animal class exit")
}

object Dog extends AnimalCounter {
  println("Dog object enter")
  val name = "dog"
  println("Dog object exit")
}

class Dog extends Animal {
  println("Dog class enter")
  def companion = Dog
  println("Dog class exit")
}

object Cat extends AnimalCounter {
  val name = "cat"
}

class Cat extends Animal {
  def companion = Cat
}

object CompanionObject extends App {
  new Dog
  //new Cat
  //new Dog
  //new Cat
}


abstract class AbstractClass;
class RealThing(s: String) extends AbstractClass;
class AlternativeThing(i: Int) extends AbstractClass;
object AbstractClass {
  def apply(s: String) = {
    new RealThing(s)
  }
  def apply(i: Int) = {
    new AlternativeThing(i)
  }
}

object CompanionObject extends App {
  val vs = AbstractClass("asdf")  // gives you the RealThing wrapped over string
  val vi = AbstractClass(123)  // gives you AlternativeThing wrapped over int
}
