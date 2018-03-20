/**
 *                        Thing             Vegetable
 *                          |
 *                       Vehicle
 *                   ----------------
 *                  /       |        \
 *                Car   Motorcycle  Bicycle
 *              /     \               |
 *          Jeep      Coupe         Tricycle
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

class Vegetable

class Parking[A](val place: A)
class Parking2[A](val place1: A, val place2: A)

// Upper type bounds
class Parking3[A <: Vehicle](val place: A)

// Lower type bounds
class Parking4[A >: Jeep](val place: A)

class Parking5[A >: Bicycle <: Vehicle](val place: A)

object typebounds extends App {
  val parkMotorcycle = new Parking[Motorcycle](new Motorcycle) // works
  // val parkMotorcycle = new Parking[Motorcycle](new Car) // compiler error
  // Car and Motorcycle are not the same type

  val parkJeep = new Parking[Car](new Jeep) // works; Jeep is a subtype of Car

  val parkCarMotorcycle = new Parking2(new Car, new Motorcycle) // works
  // If type of both parameters not same, then compiler searches for the nearest
  // common supertype, i.e
  // parkCarMotorcycle: Parking[Vehicle]

  /**
   * Upper type bounds
   *
   * val a: Parking
   *    means 'a' must be an instance of Parking or a subtype of Parking
   * In the type scenario
   *   Parking[A <: Vehicle]
   *      means 'A' type must be type or subtype of Vehicle
   */
  new Parking3(new Vehicle)
  new Parking3(new Car)
  new Parking3(new Jeep)
  new Parking3(new Coupe)
  new Parking3(new Motorcycle)
  new Parking3(new Bicycle)
  new Parking3(new Tricycle)
  //new Parking3(new AnyRef) // compiler error


  /**
   * Lower type bounds
   * class Parking4[A >: Jeep](val place: A)
   */
  new Parking4(new Jeep)
  new Parking4(new Car)
  new Parking4(new Vehicle)
  new Parking4(new AnyRef)
  new Parking4(new Coupe)
  new Parking4(new Motorcycle)

  
  // class Parking5[A >: Bicycle <: Vehicle](val place: A)
  new Parking5(new Bicycle)
  new Parking5(new Vehicle)
  new Parking5(new Tricycle)
}
