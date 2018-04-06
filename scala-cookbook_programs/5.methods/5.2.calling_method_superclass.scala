/**
 * syntax to invoke a method in an immediate parent class is the same as java
 * super refer to the parent class
 *
 * syntax: super.methodName
 *
 *          Animal
 *            |
 *          FourLeggedAnimal
 *            |
 *           Dog
 * child class continue to reach up through the parent class hierarchy unless the
 * child directly extend the target class or trait
 */

trait Animal {
  def walk { println("Animal is walking") }
}

class FourLeggedAnimal extends Animal {
  override def walk { println("I'm walking on all fours") }
}

class Dog extends FourLeggedAnimal {
  def walkThenRun {
    super.walk
    super[FourLeggedAnimal].walk
    //super[Animal].walk  // error: wont compile
  }
}

object CallingSuperclassMethodsTest extends App {
  val dog = new Dog
  dog.walkThenRun
}


/**
 * If the class inherits from multiple trait, and those traits implement the same method
 *
 *         Human
 *        /   |  \
 *     Mother |  Father   
 *        \   |   /
 *          Child
 *
 *  syntax: super[traitName].methodName
 */

trait Human {
  def hello = "the Human trait"
}
trait Mother extends Human {
  override def hello = "Mother"
}
trait Father extends Human {
  override def hello = "Father"
}

class Child extends Human with Mother with Father {
  def printSuper = super.hello
  def printMother = super[Mother].hello
  def printFather = super[Father].hello
  def printHuman = super[Human].hello
}

object CallingSuperclassesMethodsTest extends App {
  val child = new Child
  println(s"child.printSuper  = ${child.printSuper}")
  println(s"child.printMother = ${child.printMother}")
  println(s"child.printFather = ${child.printFather}")
  println(s"child.printHuman  = ${child.printHuman}")
}
