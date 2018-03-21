/**
 * Variance defines inheritance relationships of Parameterized Types
 * It is about Subtyping
 *
 * List[T]
 *  Parameterized Types are => List[Int], List[AnyVal] etc
 *
 * Advantages:
 *  variance makes scala collections more Type-Safe
 *  variance gives more flexible development
 *
 * Types
 *  Covariant
 *  Invariant
 *  Contravariant
 *
 * Covariant:
 * ---------
 *  If 'S' is subtype of 'T', then List[S] is is a subtype of List[T]
 *
 *    T     List[T]
 *    ^       ^
 *    |       |
 *    S     List[S]
 *
 *  syntax => List[+T]
 *
 *  example:
 *    Dog     Animal[Dog]
 *     ^        ^
 *     |        |
 *    Puppy   Animal[Puppy]
 */
class Dog
class Puppy extends Dog

class Animal[+T](val animal: T)
class AnimalCarer(val dog: Animal[Dog])
/*
object CovariantTest extends App {
  val dogAnimal = new Animal[Dog](new Dog)
  val puppyAnimal = new Animal[Puppy](new Puppy)

  val dogCarer = new AnimalCarer(dogAnimal)
  val puppyCarer = new AnimalCarer(puppyAnimal)

  // As Puppy is subtype of Dog, Animal[Puppy] is a subtype of Animal[Dog]
  // We can use Animal[Puppy] where we require Animal[Dog]. This is known
  // as Scala Covariance
}
*/


/**
 * Contravariant
 * -------------
 *  If 'S' is subtype of 'T' then List[T] is is a subtype of List[S]
 *
 *    T     List[S]
 *    ^       ^
 *    |       |
 *    S     List[T]
 *
 *  syntax => List[-T]
 *
 *  example:
 *    AnyVal       Int
 *     ^            ^
 *     |            |
 *    Int         AnyVal
 */

abstract class Type[-T] {
  def typeName: Unit
}

class SuperType extends Type[AnyVal] {
  override def typeName: Unit = { println("SuperType") }
}
class SubType extends Type[Int] {
  override def typeName: Unit = { println("SubType") }
}

class TypeCarer {
  def display(t: Type[Int]) { t.typeName }
}

/*
object ContravarianceTest extends App {
  val typeCarer = new TypeCarer
  typeCarer.display(new SuperType)
  typeCarer.display(new SubType)
}
*/


/********************************************************************
 * Invariant: class Parking[A]
 * ---------
 *  Car <: Vehicle    Parking[Car] !<: Parking[Vehicle]
 */
/*
class Vehicle
class Car extends Vehicle
case class Parking[A](value: A)

object InvariantTest extends App {
  //val p1: Parking[Vehicle] = Parking[Car](new Car) // compiler error
  // found : Parking[Car]
  // required: Parking[Vehicle]
  // Note: Car <: Vehicle, but class Parking is invariant in type A.
  // You may wish to define A as +A instead. (SLS 4.5)

  val p2: Parking[Vehicle] = Parking[Vehicle](new Car)
}
*/

/**
 * Covariance: class Parking[+A]
 * ----------
 *  if Car <: Vehicle Then Parking[Car] <: Parking[Vehicle]
 */
/*
class Vehicle
class Car extends Vehicle
case class Parking[+A](value: A)

object CovariantTest extends App {
  val p1: Parking[Vehicle] = Parking[Car](new Car)
}
*/

/**
 * Contravariance: class Parking[-A]
 * ----------
 *  if Car <: Vehicle Then Parking[Vehicle] <: Parking[Car]
 */
class Vehicle
class Car extends Vehicle
case class Parking[-A]()

object ContravariantTest extends App {
  val p1: Parking[Car] = Parking[Vehicle]()
}
