case class Person(username: String, password: String) {
  var age = 0
  var firstname = ""
  var lastname = ""
  // define the address field as an Option
  var address = None: Option[Address]
}
case class Address(city: String, state: String, zip: String)

object UninitializedVarTypes extends App {
  val p = Person("username", "secret")
  p.address = Some(Address("San Jose", "CA", "1234"))
  p.address.foreach{ a => 
    println(a.city)
    println(a.state)
    println(a.zip)
  }
}
