/**
 * extractor object is an object with an unapply method
 *
 * apply method is like a constructor, which takes arguments and creates an object
 * unapply method takes an object and tries to give back the arguments
 *
 * This is most often used in pattern matching and partial functions
 */
import scala.util.Random

object CustomerID {
  def apply(name: String) = s"$name--${Random.nextLong}"
  def unapply(customerID: String): Option[String] = {
    val name = customerID.split("--").head
    if(name.nonEmpty) Some(name) else None
  }
}

object ExtractorObject extends App {
  val customerID = CustomerID("Tom") // calls CustomerID's apply("Tom")
  customerID match {
    case CustomerID(name) => println(name) // calls CustomerID's unapply(customerID)
    case _ => println("Could not extract a CustomerID")
  }
}
