/**
 * type parameters and abstract types may be constrained by a type bound
 * 
 * An upper type bound T <: A declares that type variable T refers to a
 * subtype of type A
 * 
 *         Animal
 *         /    \
 *        /      \
 *      Pet     Lion
 *      / \
 *    Cat Dog
 */
abstract class Animal {
  def name: String
}

abstract class Pet extends Animal {}

class Cat extends Pet {
  override def name: String = "Cat"
}
class Dog extends Pet {
  override def name: String = "Dog"
}
class Lion extends Animal {
  override def name: String = "Lion"
}

// class PetContainer take a type parameter P which must be a subtype of Pet.
// Dog and Cat are subtypes of Pet
class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}

object UpperTypeBound extends App {
  val dogContainer = new PetContainer[Dog](new Dog)
  val catContainer = new PetContainer[Cat](new Cat)
  // PetContainer[Lion], we would get the Error
}
