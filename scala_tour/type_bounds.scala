/**
 *                        Thing             Vegetable
 *                          |
 *                       Vehicle
 *                   ----------------
 *                  /       |        \
 *                Car   Motorcycle  Bicycle
 *              /     \               |
 *          Jeep      Coupe         Tricycle
 *            /
 *        MiniJeep
 *  
 *  Thing[A] is a generic type
 *  A is abstract type
 */
trait Thing
class Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class Coupe extends Car
class Motorcycle extends Vehicle
class Bicycle extends Vehicle
class Tricycle extends Bicycle
class MiniJeep extends Jeep

class Vegetable

class Parking[A](val place: A)
class Parking2[A](val place1: A, val place2: A)

// Upper type bounds
class Parking3[A <: Vehicle](val place: A)

// Lower type bounds
class Parking4[A >: Jeep](val place: A)

class Parking5[A >: Bicycle <: Vehicle](val place: A)

object Typebounds extends App {
  new Parking[Motorcycle](new Motorcycle) // works
  //new Parking[Motorcycle](new Car) // compiler error; Car and Motorcycle are not the same type

  new Parking[Car](new Jeep) // works; Jeep is a subtype of Car

  new Parking2(new Car, new Motorcycle) // works
  // If type of both parameters not same, then compiler searches for the nearest
  // common supertype, i.e
  // parkCarMotorcycle: Parking[Vehicle]


  /**
   * Upper type bounds
   *
   * val a: Parking; means 'a' must be an instance of Parking or a subtype of Parking
   * In the type scenario
   *   Parking3[A <: Vehicle](val place: A); means 'A' type must be type or subtype of Vehicle
   */
  new Parking3(new Vehicle)
  new Parking3(new Car)
  new Parking3(new Motorcycle)
  new Parking3(new Bicycle)
  new Parking3(new Jeep)
  new Parking3(new Coupe)
  new Parking3(new Tricycle)
  new Parking3(new MiniJeep)
  //new Parking3(new AnyRef) // compiler error


  /**
   * Lower type bounds
   * class Parking4[A >: Jeep](val place: A)
   */
  new Parking4(new Jeep)
  new Parking4(new Coupe)
  new Parking4(new Tricycle)
  new Parking4(new Car)
  new Parking4(new Motorcycle)
  new Parking4(new Bicycle)
  new Parking4(new Vehicle)
  new Parking4(new AnyRef)
  new Parking4(new MiniJeep)

  
  // class Parking5[A >: Bicycle <: Vehicle](val place: A)
  new Parking5(new Bicycle)
  new Parking5(new Vehicle)
  //new Parking5(new AnyRef) // compiler error
  new Parking5(new Tricycle)
  new Parking5(new Car)
  new Parking5(new Jeep)
  new Parking5(new Coupe)
  new Parking5(new Motorcycle)

  // Lower type bounds are used to put a covariant type in a contravariant position
}
