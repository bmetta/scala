/**
 * control the visibility of fields that are used as constructor parameters in a scala
 * class
 *
 * visibility           Accessor?       Mutator?
 * ---------------------------------------------
 * var                    Yes             Yes
 * val                    Yes             No
 * Default(no var or val) No              No
 * private to var or val  No              No
 *
 * case class: constructor parameters are val by default, we can still access the fields
 * case class Person(name: String)
 *
 */
object VisibilityConstructorFields extends App {
}
