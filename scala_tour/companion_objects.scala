/**
 * companion object: an object with the same name as a class
 * class is the object's companion class
 * a companion class or object can access the private members of its companion
 * Use a companion object for methods and values which are not specific to instances
 * of the companion class
 */
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
